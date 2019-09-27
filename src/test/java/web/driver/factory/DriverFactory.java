package test.java.web.driver.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import test.java.common.*;
import test.java.pages.*;
import java.io.*;
import java.net.*;

public abstract class DriverFactory {

    private static AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;
    private static ThreadLocal<DriverThread> driverThread;
    public static AndroidPage andr = new AndroidPage();
    public static Utility util = new Utility();

    @BeforeSuite
    public void globalSetup () {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @BeforeClass
    public static AndroidDriver setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, andr.APK_PATH);
        File app = new File(appDir.getCanonicalPath(), andr.APK);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", andr.DEVICE_NAME);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("android:noHistory", true);
        capabilities.setCapability("appPackage", andr.APP_PACKAGE);
        capabilities.setCapability("appActivity", andr.APP_ACTIVITY);
        driver = new AndroidDriver<WebElement>(getServiceUrl(), capabilities);
        return driver;
    }
    @BeforeMethod
    public void startApp(){
        getServiceUrl();
    }

    @AfterMethod
    public void resetApp(){
        driver.resetApp();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void quitDriverSingle(){
        if(null!=driverThread.get()){
            driverThread.get().quitDriver();
        }
    }
    @AfterSuite
    public void globalTearDown () {
        service.stop();
    }

    public static URL getServiceUrl () {
        return service.getUrl();
    }
}
