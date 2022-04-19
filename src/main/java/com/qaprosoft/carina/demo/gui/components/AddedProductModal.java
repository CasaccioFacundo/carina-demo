package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeShoppingCartSummary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddedProductModal extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='product-name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//span[@id='layer_cart_product_price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//span[@title='Continue shopping']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = ".//a[@title='Proceed to checkout']")
    private ExtendedWebElement proceedToCheckOutButton;

    public AddedProductModal(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public AutomationPracticeShoppingCartSummary clickProceedToCheckOutButton() {
        proceedToCheckOutButton.click();
        return new AutomationPracticeShoppingCartSummary(driver);
    }
}
