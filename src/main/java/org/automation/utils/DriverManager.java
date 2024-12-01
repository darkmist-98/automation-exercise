package org.automation.utils;

import org.automation.listener.EventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    // Method to set the WebDriver instance using the Factory class
    public static void setDriver() {
        String browser = System.getProperty("browser","chrome");
        System.out.println("Browser active: " +browser);
        BrowserType browserType = BrowserFactory.getBrowserType(browser);
        WebDriver driver = BrowserFactory.createDriver(browserType);
        driverThreadLocal.set(driver);
    }


    // Method to get the driver instance
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // Method to Quit the driver & Remove it from ThreadLocal
    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }


}
