package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeMyAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import com.qaprosoft.carina.demo.utils.AuthService;
import com.qaprosoft.carina.demo.utils.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeLogInTest implements IAbstractTest {
    AuthService authService = new AuthService();
    ScreenshotService screenshotService = new ScreenshotService();

    @Test()
    public void testLogInInvalidPassword() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Navigate to sign in page
        AutomationPracticeSignInPage signInPage = homePage.clickSignInLink();

        //Fill in valid user and invalid password
        authService.signIn();

        //Take screenshot of result
        screenshotService.takeScreenshot();

        //Check for error alert
        Assert.assertTrue(signInPage.getAuthenticationErrorAlertMessage(), "Authentication failed.");
    }

    @Test()
    public void testLogIn() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Navigate to sign in page
        homePage.clickSignInLink();

        //Fill in valid email and password
        authService.signIn("correctregisteredmail@gmail.com", "pswd123");

        //Check for account page
        AutomationPracticeMyAccountPage myAccountPage = new AutomationPracticeMyAccountPage(getDriver());

        //Take screenshot of result
        screenshotService.takeScreenshot("login");

        //Verify redirected to my account page
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));
        Assert.assertEquals(myAccountPage.getBreadcrumb(), "My account");
    }
}
