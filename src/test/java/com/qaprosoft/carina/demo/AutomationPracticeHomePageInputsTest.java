package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AutomationPracticeHomePageInputsTest implements IAbstractTest {

    @Test()
    public void testSearchProduct() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Search for product
        AutomationPracticeSearchResultPage searchResultPage = homePage.searchProduct("blouse");

        //Check counter, products shown and if they match
        Assert.assertTrue(searchResultPage.isAnyResultFound());
        Assert.assertTrue(searchResultPage.isAnyProductShown());
        Assert.assertTrue(searchResultPage.resultAndCounterMatch());
    }

    @Test()
    public void testSubscribeToNewsletter() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Subscribe to newsletter
        homePage.subscribeNewsletter("randomemail" + new Random().nextInt() + "@gmail.com");

        //Check for success alert
        Assert.assertTrue(homePage.isSuccessfulAlertPresent(), "Error subscribing to newsletter");
    }

}
