package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutomationPracticeSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//ul[@class='product_list']/li")
    private List<ProductCard> products;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private ExtendedWebElement resultsCounter;

    public AutomationPracticeSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeAddedProductModalPage addProductToCart(String name) {
        for (ProductCard product:products) {
            if(product.getProductName().equalsIgnoreCase(name))
                product.clickAddToCartButton();
        }
        return new AutomationPracticeAddedProductModalPage(driver);
    }

    public String getResultsCounter(){
        return resultsCounter.getText();
    }

}

