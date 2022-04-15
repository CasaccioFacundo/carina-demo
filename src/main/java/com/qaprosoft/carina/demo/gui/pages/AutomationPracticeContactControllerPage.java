package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeContactControllerPage extends AbstractPage {

    @FindBy(xpath = "//a[class][contains(@href='http://automationpractice.com/')]")
    private ExtendedWebElement home;

    public AutomationPracticeContactControllerPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeHomePage returnHome() {
        this.home.click();
        return new AutomationPracticeHomePage(driver);
    }
}
