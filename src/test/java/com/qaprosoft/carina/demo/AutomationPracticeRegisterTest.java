package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeCreateAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeMyAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import com.qaprosoft.carina.demo.utils.AuthService;
import com.qaprosoft.carina.demo.utils.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeRegisterTest implements IAbstractTest {

    AuthService authService = new AuthService();
    ScreenshotService screenshotService = new ScreenshotService();

    @Test()
    public void testCreateAccount() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homepage = new AutomationPracticeHomePage(getDriver());
        homepage.open();
        Assert.assertTrue(homepage.isPageOpened(), "Home page is not opened");

        //Navigate to sign in page
        AutomationPracticeSignInPage signInPage = homepage.clickSignInLink();

        //Fill email and click create account
        AutomationPracticeCreateAccountPage createAccountPage = signInPage.createAccountWithEmail(authService.generateRandomEmail());

        //Fill register form fields
        authService.createAccount();

        //Submit registration form
        AutomationPracticeMyAccountPage myAccountPage = createAccountPage.clickRegisterButton();

        //Take screenshot of result
        screenshotService.takeScreenshot("registerTest");

        //Verify redirected to my account page
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));
        Assert.assertEquals(myAccountPage.getBreadcrumb(), "My account");
    }
}
