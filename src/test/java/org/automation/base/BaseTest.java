package org.automation.base;

import org.automation.listener.EventListener;
import org.automation.utils.ConfigReader;
import org.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @BeforeMethod
    @Parameters({"browser","headless"})
    public void init(String browser, String headless) {
        System.setProperty("browser",browser);
        System.setProperty("headless",headless);
        DriverManager.setDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(new ConfigReader().getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
