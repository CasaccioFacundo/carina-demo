package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeCreateAccountPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Random;

public class AuthService implements IDriverPool {

    private WebDriver getDriverSafe() {
        WebDriver driver = getDriver();
        if (driver instanceof EventFiringWebDriver) {
            driver = ((EventFiringWebDriver) driver).getWrappedDriver();
        }
        return driver;
    }

    public void signIn(String email, String password) {
        AutomationPracticeSignInPage signInPage = new AutomationPracticeSignInPage(getDriverSafe());

        signInPage.typeEmail(email);
        signInPage.typePassword(password);
        signInPage.clickSignInButton();
    }

    public void signIn() {
        AutomationPracticeSignInPage signInPage = new AutomationPracticeSignInPage(getDriverSafe());

        signInPage.typeEmail(generateRandomEmail());
        signInPage.typePassword(generateRandomPassword());
        signInPage.clickSignInButton();
    }

    public void createAccount() {
        AutomationPracticeCreateAccountPage createAccountPage = new AutomationPracticeCreateAccountPage(getDriverSafe());

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
    }

    public String generateRandomEmail() {
        return "randomemail" + new Random().nextInt() + "@gmail.com";
    }

    public String generateRandomPassword() {
        return "password" + new Random().nextInt();
    }
}
