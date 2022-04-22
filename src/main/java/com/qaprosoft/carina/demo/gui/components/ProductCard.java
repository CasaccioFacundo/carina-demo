package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='product-name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//a[@class='product-price'")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//a[@title='Add to cart']")
    private ExtendedWebElement addToCartButton;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAddToCartButton() {
        productName.hover();
        addToCartButton.click();
    }


    public String getProductName() {
        return productName.getText();
    }
}
