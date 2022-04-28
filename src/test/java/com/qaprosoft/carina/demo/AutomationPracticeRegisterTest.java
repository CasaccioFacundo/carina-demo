package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeCreateAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeMyAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import com.qaprosoft.carina.demo.utils.AuthService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AutomationPracticeRegisterTest implements IAbstractTest {

    AuthService authService = new AuthService();

    @Test()
    public void testCreateAccount() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homepage = new AutomationPracticeHomePage(getDriver());
        homepage.open();
        Assert.assertTrue(homepage.isPageOpened(), "Home page is not opened");

        //Navigate to sign in page
        AutomationPracticeSignInPage signInPage = homepage.clickSignInLink();

        //Fill email and click create account
        AutomationPracticeCreateAccountPage createAccountPage = signInPage.createAccountWithEmail("randomemail" + new Random().nextInt() + "@gmail.com");

        //Fill register form fields
        authService.createAccount(createAccountPage);

        //Submit registration form
        AutomationPracticeMyAccountPage myAccountPage = createAccountPage.clickRegisterButton();

        //Verify redirected to my account page
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));
        Assert.assertEquals(myAccountPage.getBreadcrumb(), "My account");
    }
}
