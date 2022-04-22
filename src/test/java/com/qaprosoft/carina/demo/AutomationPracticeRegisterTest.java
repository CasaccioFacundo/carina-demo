package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeCreateAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeMyAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AutomationPracticeRegisterTest implements IAbstractTest {

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
        createAccountPage.selectGender("male");
        createAccountPage.fillPersonalFirstName("Name");
        createAccountPage.fillPersonalLastName("LastName");
        createAccountPage.fillPassword("pswd123");
        createAccountPage.selectBirthDate(1,2,1990);
        createAccountPage.fillAddress("Street 1");
        createAccountPage.fillCity("City");
        createAccountPage.selectState("Iowa");
        createAccountPage.fillZipCode("00000");
        createAccountPage.selectCountry("United States");
        createAccountPage.fillMobilePhone("11234456");

        //Submit registration form
        AutomationPracticeMyAccountPage myAccountPage = createAccountPage.clickRegisterButton();

        //Verify redirected to my account page
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));
        Assert.assertEquals(myAccountPage.getBreadcrumb(), "My account");
    }
}
