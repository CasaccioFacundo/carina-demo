package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationPracticeHomePageInputsTest implements IAbstractTest {

    @Test()
    public void testSearchProduct() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Search for product
        AutomationPracticeSearchResultPage searchResultPage = homePage.searchProduct("blouse");

        //Check if any result was shown
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchResultPage.getResultsCounter(), "\n" +
                "            1 result has been found.        ");

    }

    @Test()
    public void testSubscribeToNewsletter() {
        // Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Subscribe to newsletter
        homePage.subscribeNewsletter("randomemail@gmail.com");

        //Check for success alert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getNewsletterSubscribedAlert(), " Newsletter : You have successfully subscribed to this newsletter.");
    }

}
