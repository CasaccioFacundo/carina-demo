package com.qaprosoft.carina.demo.gui.pages;

import com.amazonaws.services.s3.model.PublicAccessBlockConfiguration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeShoppingCartSummary extends AbstractPage {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckout;

    public AutomationPracticeShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeAuthenticationPage proceedCheckout() {
        this.proceedToCheckout.click();
        return new AutomationPracticeAuthenticationPage(driver);
    }
}
