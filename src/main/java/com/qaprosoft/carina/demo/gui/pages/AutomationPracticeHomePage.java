package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends AbstractPage {

    @Localized
    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    public AutomationPracticeHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://automationpractice.com/index.php");
    }

    public WebElement getSearchBox(){
        return this.searchBox;
    }
}

