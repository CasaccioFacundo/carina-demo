package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends AbstractPage {

    @FindBy(id = "search_query_top")
    private ExtendedWebElement searchBoxInput;

    @FindBy(name = "submit_search")
    private ExtendedWebElement submitSearchBox;

    @FindBy(id = "newsletter-input")
    private ExtendedWebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    private ExtendedWebElement newsletterSubmit;

    @FindBy(className = "alert-success")
    private ExtendedWebElement newsletterSucceedAlert;

    @FindBy(xpath = "//a[@title='Contact Us']")
    private ExtendedWebElement contactLink;

    @FindBy(className = "login")
    private ExtendedWebElement signInLink;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private ExtendedWebElement cart;

    public AutomationPracticeHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://automationpractice.com/index.php");
    }

    public AutomationPracticeSignInPage clickSignInLink() {
        signInLink.click();
        return new AutomationPracticeSignInPage(driver);
    }

    public AutomationPracticeSearchResultPage searchProduct(String text){
        searchBoxInput.type(text);
        submitSearchBox.click();
        return new AutomationPracticeSearchResultPage(driver);
    }

    public void subscribeNewsletter(String email){
        newsletterInput.type(email);
        newsletterSubmit.click();
    }
}

