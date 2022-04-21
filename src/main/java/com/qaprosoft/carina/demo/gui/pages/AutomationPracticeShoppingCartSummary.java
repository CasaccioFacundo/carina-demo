package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeShoppingCartSummary extends AbstractPage {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    public AutomationPracticeShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeSignInPage clickProceedCheckout() {
        proceedToCheckoutButton.click();
        return new AutomationPracticeSignInPage(driver);
    }
}
