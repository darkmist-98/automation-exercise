package org.automation.tests;

import org.automation.base.BaseTest;
import org.automation.pages.HomePage;
import org.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(priority = 1)
    public void verifyHomepageTitleTest() {
        Assert.assertEquals(homePage.getPageTitle(),"Home Page");
    }

    @Test(priority = 2,enabled = false)
    public void verifySignInLinkVisibleTest() {
        Assert.assertTrue(homePage.isSignInLinkDisplayed(),"Sign In Link not displayed");
    }

    @Test(priority = 3, enabled = false)
    public void verifyClickOnSignInTest() {
        LoginPage loginPage = homePage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getCustomerLoginText(),"Customer Login",
                "Click on SignIn failed.");
    }

}
