package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends AbstractPage {

    @FindBy(id = "search_query_top")
    private ExtendedWebElement searchBox;

    @FindBy(name = "submit_search")
    private ExtendedWebElement submitSearch;

    @FindBy(id = "newsletter-input")
    private ExtendedWebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    private ExtendedWebElement newsletterSubmit;

    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    private ExtendedWebElement contactLink;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private ExtendedWebElement logIn;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private ExtendedWebElement cart;

    public AutomationPracticeHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://automationpractice.com/index.php");
    }

    public ExtendedWebElement getSearchBox(){
        return this.searchBox;
    }

    public ExtendedWebElement getSubmitSearch() {
        return submitSearch;
    }

    public ExtendedWebElement getNewsletterInput() {
        return newsletterInput;
    }

    public ExtendedWebElement getNewsletterSubmit() {
        return newsletterSubmit;
    }

    public ExtendedWebElement getContactLink() {
        return contactLink;
    }

    public ExtendedWebElement getLogIn() {
        return logIn;
    }

    public ExtendedWebElement getCart() {
        return cart;
    }
}

