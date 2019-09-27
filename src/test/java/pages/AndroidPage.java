package test.java.pages;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import static java.util.ResourceBundle.getBundle;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.common.Utility;

public class AndroidPage extends Page {
    private final ResourceBundle resourceBundle;
    public final String APP_PACKAGE;
    public final String APP_ACTIVITY;
    public final String APK_PATH;
    public final String APK;
    public final String DEVICE_NAME;
    public final String EMAIL_FIELD_ID;
    public final String ENTER_EMAIL_TEXT;
    public final String ENTER_EMAIL_FIELD_ID;
    public final String KEYBOARD_ID;
    public final String EMAIL;
    public final String EMAIL_PWD;
    public final String REGEX_TOKEN;
    public final String RIDE_BTN_ID;
    public final String CODE_FIELD_ID;
    public final String HOW_TO_RIDE_ID;
    public final String TUTORIAL_PAGE_ID;
    public final String TUTORIAL_PAGE_TEXT;
    public final String NEXT_BTN_ID;

    public AndroidPage() {
        resourceBundle = getBundle("pages.AndroidPage");
        APP_PACKAGE = this.getResourceBundle().getString("APP_PACKAGE");
        APP_ACTIVITY = this.getResourceBundle().getString("APP_ACTIVITY");
        APK_PATH = this.getResourceBundle().getString("APK_PATH");
        APK = this.getResourceBundle().getString("APK");
        DEVICE_NAME = this.getResourceBundle().getString("DEVICE_NAME");
        EMAIL_FIELD_ID = this.getResourceBundle().getString("EMAIL_FIELD_ID");
        ENTER_EMAIL_TEXT = this.getResourceBundle().getString("ENTER_EMAIL_TEXT");
        ENTER_EMAIL_FIELD_ID = this.getResourceBundle().getString("ENTER_EMAIL_FIELD_ID");
        KEYBOARD_ID = this.getResourceBundle().getString("KEYBOARD_ID");
        EMAIL = this.getResourceBundle().getString("EMAIL");
        EMAIL_PWD = this.getResourceBundle().getString("EMAIL_PWD");
        REGEX_TOKEN = this.getResourceBundle().getString("REGEX_TOKEN");
        RIDE_BTN_ID = this.getResourceBundle().getString("RIDE_BTN_ID");
        CODE_FIELD_ID = this.getResourceBundle().getString("CODE_FIELD_ID");
        HOW_TO_RIDE_ID = this.getResourceBundle().getString("HOW_TO_RIDE_ID");
        TUTORIAL_PAGE_ID = this.getResourceBundle().getString("TUTORIAL_PAGE_ID");
        TUTORIAL_PAGE_TEXT = this.getResourceBundle().getString("TUTORIAL_PAGE_TEXT");
        NEXT_BTN_ID = this.getResourceBundle().getString("NEXT_BTN_ID");
    }
    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    private int wait = 10;

    public void sighUp() throws Exception {
        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
        email.sendKeys(andr.EMAIL);
        AndroidElement signup = (AndroidElement) new WebDriverWait(driver, wait)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.RIDE_BTN_ID)));
        signup.click();
        AndroidElement code = (AndroidElement) new WebDriverWait(driver, wait)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.CODE_FIELD_ID)));
        code.sendKeys(Utility.returnTokenFromEmail());
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }
}

