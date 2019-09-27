package test.java.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;
import java.util.*;
import java.util.regex.*;
import static test.java.web.driver.factory.DriverFactory.andr;

public class Utility{
    private AndroidDriver driver;

    public static void waitUntilElementDisplayed(AndroidDriver driver, int sec, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public static void waitUntilElementDisappear(AndroidDriver driver, int sec, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public static void clickJs(AndroidDriver driver, String element) {
        WebElement button = driver.findElement(By.id(element));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", button);
    }

    public static String returnTokenFromEmail() throws Exception {
        Session session = Session.getDefaultInstance(new Properties( ));
        Store store = session.getStore("imaps");
        store.connect("imap.googlemail.com", 993, andr.EMAIL, andr.EMAIL_PWD);
        Folder inbox = store.getFolder( "INBOX" );
        inbox.open( Folder.READ_ONLY );
        Message[] messages = inbox.search(
                new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        Arrays.sort( messages, ( m1, m2 ) -> {
            try {
                return m2.getSentDate().compareTo( m1.getSentDate() );
            } catch ( MessagingException e ) {
                throw new RuntimeException( e );
            }
        } );
        String result = "";
        String code = "";
        for ( Message message : messages ) {
            result = getTextFromMessage(message).toString();
            Pattern p = Pattern.compile(andr.REGEX_TOKEN);
            Matcher m = p.matcher(result);
            while (m.find()){
                System.out.println("Generated code: "+m.group(1));
                return m.group(1);
            }
        }
        return code;
    }

    public static String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")){
            return message.getContent().toString();
        }else if (message.isMimeType("multipart/*")) {
            String result = "";
            MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
            int count = mimeMultipart.getCount();
            for (int i = 0; i < count; i ++){
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")){
                    result = result + "\n" + bodyPart.getContent();
                    break;
                } else if (bodyPart.isMimeType("text/html")){
                    String html = (String) bodyPart.getContent();
                    result = result + "\n" + Jsoup.parse(html).text();
                }
            }
            return result;
        }
        return "";
    }
    public static void waitForTitleIs(AndroidDriver driver, String titleIs, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.titleIs(titleIs));
    }

    public static void waitForElementVisible(AndroidDriver driver, By element, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitForElementDisappear(AndroidDriver driver, By element, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static void clickVisibleElement(AndroidDriver driver, String element, int TIMEOUT) {
        AndroidElement email = (AndroidElement) new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        email.click();
    }
}

