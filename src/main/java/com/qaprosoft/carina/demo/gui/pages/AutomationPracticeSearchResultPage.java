package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Add to cart']")
    private ExtendedWebElement addToCart;

    @FindBy(className = "heading-counter")
    private ExtendedWebElement resultsCounter;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckout;

    @FindBy(className = "cart_block_product_name")
    private ExtendedWebElement cartProduct;

    public AutomationPracticeSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        this.addToCart.click();
    }

    public AutomationPracticeShoppingCartSummary continueCheckout() {
        this.proceedToCheckout.click();
        return new AutomationPracticeShoppingCartSummary(driver);
    }
}

