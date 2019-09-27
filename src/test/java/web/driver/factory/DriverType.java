package test.java.web.driver.factory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.*;
import java.io.*;

public enum DriverType implements DriverSetup {
    ANDROID {
        public DesiredCapabilities getDesiredCapabilities() {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File app = new File(classpathRoot, "/src/main/resources/apk/bird.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("appPackage", "co.bird.android");
            capabilities.setCapability("appActivity", "co.bird.android.app.feature.main.MainActivity");
            return capabilities;
        }
        public AndroidDriver getWebDriverObject(DesiredCapabilities capabilities){
            return new AndroidDriver<>(capabilities);
        }
    }

}
