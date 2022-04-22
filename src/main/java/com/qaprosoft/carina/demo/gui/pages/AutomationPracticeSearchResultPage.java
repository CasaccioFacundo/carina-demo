package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutomationPracticeSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='product-container']")
    private List<ProductCard> products;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private ExtendedWebElement resultsCounter;

    public AutomationPracticeSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeAddedProductModalPage addProductToCart(String name) {
        ProductCard productCard;
        for (int i = 0; i < products.size(); i++) {
            productCard = products.get(i);
            if(productCard.getProductName().equalsIgnoreCase(name)) {
                productCard.clickAddToCartButton();
            }
        }
        return new AutomationPracticeAddedProductModalPage(driver);
    }

    public String getResultsCounter(){
        return resultsCounter.getText();
    }

    public boolean isAnyResultFound() {
        return !resultsCounter.getText().equalsIgnoreCase("\n" +
                "            0 results have been found.        ");
    }

    public boolean isAnyProductShown() {
        return !products.isEmpty();
    }

    public boolean resultAndCounterMatch() {
        return products.size() == Integer.parseInt(resultsCounter.getText().replaceAll("[^0-9]", ""));
    }
}

