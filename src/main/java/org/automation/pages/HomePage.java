package org.automation.pages;

import org.automation.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Sign In")
    private WebElement signInLinkText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSignInLinkDisplayed() {
        Helper.isElementVisible(driver,signInLinkText);
        return signInLinkText.isDisplayed();
    }

    public LoginPage clickOnSignInLink() {
        if (isSignInLinkDisplayed()) {
            signInLinkText.click();
            return new LoginPage(driver);
        }
        return null;
    }

}
