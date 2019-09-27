package test.java.pages;

import test.java.web.driver.factory.DriverFactory;
import java.util.ResourceBundle;

public abstract class Page extends DriverFactory {
    public abstract ResourceBundle getResourceBundle();
}