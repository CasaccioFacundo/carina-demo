package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeSignInPage extends AbstractPage {

    //Account creation
    @FindBy(id = "email_create")
    private ExtendedWebElement accountCreationEmailInput;

    @FindBy(id = "SubmitCreate")
    private ExtendedWebElement createAccountButton;

    //Login
    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "passwd")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signInButton;

    public AutomationPracticeSignInPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeCreateAccountPage clickCreateAccount(String email) {
        accountCreationEmailInput.type(email);
        createAccountButton.click();
        return new AutomationPracticeCreateAccountPage(driver);
    }

    public void failLogin(String email, String incorrectPassword) {
        emailInput.type(email);
        passwordInput.type(incorrectPassword);
        signInButton.click();
    }
}
