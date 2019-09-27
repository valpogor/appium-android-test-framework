package test.java.ui;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;
import test.java.pages.AndroidPage;
import java.util.concurrent.TimeUnit;

public class AndroidTest extends AndroidPage {
    private int wait = 10;

//    @Test()
//    public void verifyAppOpens() {
//        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
//        Assert.assertEquals(email.getText(), andr.ENTER_EMAIL_TEXT);
//    }
//
//    @Test()
//    public void verifyCloseKeyboard() {
//        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
//        email.click();
//        if(driver.findElementsById(andr.KEYBOARD_ID).size()!=0) {
//            email.sendKeys(Keys.ENTER);
//        }
//        Assert.assertTrue(driver.findElementsById(andr.KEYBOARD_ID).size()==0);
//    }
//
//    @Test()
//    public void verifyNoEmail() {
//        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
//        Assert.assertTrue(email.getText().contains(andr.ENTER_EMAIL_TEXT));
//    }
//
//    @Test()
//    public void verifyEmailErrorMsg() {
//        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
//        String before = email.getAttribute(andr.ENTER_EMAIL_FIELD_ID);
//        email.sendKeys(".");
//        String after = email.getAttribute(andr.ENTER_EMAIL_FIELD_ID);
//        Assert.assertTrue(before!=after,"Should appear error msg: Invalid email. Please try again.");
//    }
//
//    @Test()
//    public void verifyValidEmail(){
//        AndroidElement email = (AndroidElement) new WebDriverWait(driver, wait)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(andr.EMAIL_FIELD_ID)));
//        email.sendKeys(andr.EMAIL);
//        Assert.assertTrue(email.getText().contains(andr.EMAIL));
//    }
//
//    @Test()
//    public void verifySighUp() throws Exception {
//        andr.sighUp();
//        Assert.assertTrue(driver.findElementById(andr.HOW_TO_RIDE_ID).isDisplayed());
//    }
//
//    @Test()
//    public void verifyHowToRide() throws Exception {
//        andr.sighUp();
//        util.clickVisibleElement(driver, andr.HOW_TO_RIDE_ID, wait);
//        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
//        Assert.assertTrue(driver.findElement(By.id(andr.TUTORIAL_PAGE_ID)).isDisplayed());
//    }

//    @Test()
//    public void verifyTutorialNextBtn() throws Exception {
//        andr.sighUp();
//        util.clickVisibleElement(driver, andr.HOW_TO_RIDE_ID, wait);
//        util.clickVisibleElement(driver, andr.NEXT_BTN_ID, wait);
//        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
////        Assert.assertTrue(driver.findElement(By.id(andr.TUTORIAL_PAGE_ID)).getText().contains(andr.TUTORIAL_PAGE_TEXT));
//        Thread.sleep(100000000);
//    }

//    @Test()
//    public void verifyReturnTokenFromEmail() throws Exception {
//        String token = util.returnTokenFromEmail();
//        Assert.assertFalse(token.isEmpty());
//    }


    @Test()
    public void verifyTutorialNextBtn2() throws Exception {
        andr.sighUp();
        util.clickVisibleElement(driver, "background", wait);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
//        Assert.assertTrue(driver.findElement(By.id(andr.TUTORIAL_PAGE_ID)).getText().contains(andr.TUTORIAL_PAGE_TEXT));
//        Thread.sleep(100000000);
    }
}