package org.automation.tests;

import org.automation.base.BaseTest;
import org.automation.pages.HomePage;
import org.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void SetUp() {
        HomePage homePage = new HomePage(getDriver());
        loginPage = homePage.clickOnSignInLink();
    }

    @Test(priority = 1)
    public void verifyCustomerLogInTextTest() {
        Assert.assertEquals(loginPage.getCustomerLoginText(),"Customer Login",
                "Text not matched.");
    }

    @Test(priority = 2)
    public void verifyPageTitleTest() {
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Customer Login",
                "Incorrect page title found.");
    }


}
