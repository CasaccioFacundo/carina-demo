package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeLogInTest implements IAbstractTest {

    @Test()
    public void testLogInInvalidPassword() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Navigate to sign in page
        AutomationPracticeSignInPage signInPage = homePage.clickSignInLink();

        //Fill in valid user and invalid password
        signInPage.failLogin("correctuser@gmail.com", "incorrectpwd");

        //Check for error alert
        Assert.assertEquals(signInPage.getAuthenticationErrorAlertMessage(), "Authentication failed.");
    }
}
