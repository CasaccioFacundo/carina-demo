package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeSignInPage extends AbstractPage {

    //Account creation
    @FindBy(xpath = "//input[@id='email_create']")
    private ExtendedWebElement accountCreationEmailInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private ExtendedWebElement createAccountButton;

    //Login
    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='passwd']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//li[text()='Authentication failed.']")
    private ExtendedWebElement authenticationErrorAlert;

    public AutomationPracticeSignInPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeCreateAccountPage createAccountWithEmail(String email) {
        accountCreationEmailInput.type(email);
        createAccountButton.click();
        return new AutomationPracticeCreateAccountPage(driver);
    }

    public void failLogin(String email, String incorrectPassword) {
        emailInput.type(email);
        passwordInput.type(incorrectPassword);
        signInButton.click();
    }

    public String getSignInButton() {
        return signInButton.getText();
    }

    public String getCreateAccountButton() {
        return createAccountButton.getText();
    }

    public String getAuthenticationErrorAlertMessage() {
        return authenticationErrorAlert.getText();
    }
}
