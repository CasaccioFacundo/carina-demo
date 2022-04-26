package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeAddedProductModalPage extends AbstractPage {


    @FindBy(xpath = "//span[@id='layer_cart_product_title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//span[@id='layer_cart_product_price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckOutButton;

    public AutomationPracticeAddedProductModalPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeSearchResultPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new AutomationPracticeSearchResultPage(driver);
    }

    public AutomationPracticeShoppingCartSummary clickProceedToCheckOutButton() {
        proceedToCheckOutButton.click();
        return new AutomationPracticeShoppingCartSummary(driver);
    }

    public boolean isProceedToCheckOutButtonPresent() {
        return proceedToCheckOutButton.isElementPresent() ;
    }

    public String getProductNameOnModal() {
        return productName.getText();
    }

    public boolean isCartNotEmpty() {
        return productName.isElementPresent();
    }
}
