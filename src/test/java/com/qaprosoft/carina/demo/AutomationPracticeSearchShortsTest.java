package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeLocalePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
    This tests searches for faded shorts in the store
    compares the result to be 1 if correct

    @author CasaccioFacundo

 */
public class AutomationPracticeSearchShortsTest implements IAbstractTest {

    @Test
    public void searchFadedShort() {
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();

        WebElement searchBox = homePage.getSearchBox();
        searchBox.clear();
        searchBox.sendKeys("faded short");
        searchBox.submit();

        try {
            wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AutomationPracticeLocalePage localePage = new AutomationPracticeLocalePage(getDriver());
        WebElement result = localePage.getResult();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result.getText(), "1 result has been found.");
    }





}
