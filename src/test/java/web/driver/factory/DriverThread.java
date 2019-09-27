package test.java.web.driver.factory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverThread {
    private AndroidDriver<WebElement> webdriver;
    private DriverType selectDriverType;
    private final DriverType defaultDriverType = DriverType.ANDROID;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public AndroidDriver getDriver(String driverType){
        if(null==webdriver){
            selectDriverType = determineDriverType(driverType);
            DesiredCapabilities desiredCapabilities = selectDriverType.getDesiredCapabilities();
            instantiateWebDriver(desiredCapabilities);
        }
        return webdriver;
    }
    public void quitDriver(){
        if(null!=webdriver){
            webdriver.quit();
            webdriver = null;
        }
    }
    private DriverType determineDriverType(String driverType){
        DriverType dt = defaultDriverType;
        try{
            dt = DriverType.valueOf(driverType.toUpperCase());
        }
        catch (IllegalArgumentException ignored){
            System.err.println(String.format("Unknown driver specified, defaulting to: %s.", driverType));
        }catch (NullPointerException ignored){
            System.err.println(String.format("No driver specified, defaulting to: %s.", driverType));
        }
        return dt;
    }
    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities){
        System.out.println(" ");
        System.out.println("Current OS: " + operatingSystem);
        System.out.println("Current Architecture: "+systemArchitecture);
        System.out.println("Current Browser Selection: "+ selectDriverType);
        System.out.println(" ");
        webdriver = (AndroidDriver) selectDriverType.getWebDriverObject(desiredCapabilities);
    }
}
