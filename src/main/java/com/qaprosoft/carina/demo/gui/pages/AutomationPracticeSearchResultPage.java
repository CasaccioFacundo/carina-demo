package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.AddedProductModal;
import com.qaprosoft.carina.demo.gui.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='product-container']")
    private ProductCard productCard;

    @FindBy(xpath = "//div[@id='layer_cart']")
    private AddedProductModal addedProductModal;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private ExtendedWebElement resultsCounter;

    public AutomationPracticeSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        productCard.clickAddToCartButton();
    }

    public AutomationPracticeShoppingCartSummary clickContinueCheckout() {
        return addedProductModal.clickProceedToCheckOutButton();
    }
}

