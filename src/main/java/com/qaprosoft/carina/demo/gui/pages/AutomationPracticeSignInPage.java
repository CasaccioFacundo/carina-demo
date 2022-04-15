package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeSignInPage extends AbstractPage {

    //Account creation
    @FindBy(id = "email_create")
    private ExtendedWebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private ExtendedWebElement createAccount;

    //Login
    @FindBy(id = "email")
    private ExtendedWebElement email;

    @FindBy(id = "passwd")
    private ExtendedWebElement password;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signIn;

    public AutomationPracticeSignInPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeCreateAccountPage createAccount(String email) {
        this.emailCreate.type(email);
        this.createAccount.click();
        return new AutomationPracticeCreateAccountPage(driver);
    }

    public void failLogin(String email, String incorrectPassword) {
        this.email.type(email);
        this.password.type(incorrectPassword);
        this.signIn.click();
    }
}
