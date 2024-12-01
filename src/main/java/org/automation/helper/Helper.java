package org.automation.helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    public static boolean isElementVisible(WebDriver driver, WebElement element) {
        try {
            waitForElementVisibility(driver, element, 30);
            return element.isDisplayed();   // Check if element is displayed
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void waitForElementVisibility(WebDriver driver, WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " +element, e);
        }
    }

}
