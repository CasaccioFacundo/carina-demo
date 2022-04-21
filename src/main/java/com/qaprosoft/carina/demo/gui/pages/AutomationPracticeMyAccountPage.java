package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeMyAccountPage extends AbstractPage {
    @FindBy(xpath = "//span[text()='My account']")
    private ExtendedWebElement myAccountBreadcrumb;

    public AutomationPracticeMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getBreadcrumb() {
        return myAccountBreadcrumb.getText();
    }
}
