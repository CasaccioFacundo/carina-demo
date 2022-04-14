package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeLocalePage extends AbstractPage {

    @Localized
    @FindBy(css = "span.heading-counter")
    private WebElement result;

    public AutomationPracticeLocalePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getResult() {
        return this.result;
    }
}
