package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeAuthenticationPage extends AbstractPage {

    @FindBy(id = "SubmitCreate")
    private ExtendedWebElement createAccount;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signIn;

    public AutomationPracticeAuthenticationPage(WebDriver driver) {
        super(driver);
    }
}
