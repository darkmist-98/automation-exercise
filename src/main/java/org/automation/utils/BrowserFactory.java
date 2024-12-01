package org.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    // Factory method to create a WebDriver instance based on the BrowserType
    public static WebDriver createDriver(BrowserType browserType) {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless","false"));
        System.out.println("isHeadless is: " +isHeadless);
        WebDriver driver;

        switch (browserType) {
            case FIREFOX:
                return createFirefoxDriver(isHeadless);
            case CHROME:
            default:
                return createChromeDriver(isHeadless);
        }
    }


    // Convert String to BrowserType ENUM
    public static BrowserType getBrowserType(String browser) {
        try {
            System.out.println("GetbrowserType: " +browser);
            return BrowserType.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Entered GetBrowserType Catch block");
            return BrowserType.CHROME;  // Default to Chrome if the input is invalid
        }
    }

    private static WebDriver createChromeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }
        return new FirefoxDriver(options);
    }


}
