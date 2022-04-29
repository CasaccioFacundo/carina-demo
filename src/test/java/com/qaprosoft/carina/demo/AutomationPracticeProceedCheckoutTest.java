package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.utils.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeProceedCheckoutTest implements IAbstractTest {

    ScreenshotService screenshotService = new ScreenshotService();

    @Test()
    public void testProceedCheckoutWithoutLogin() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Search for product and check products were found
        AutomationPracticeSearchResultPage searchResultPage = homePage.searchProduct("Blouse");
        Assert.assertTrue(searchResultPage.allElementListsAreNotEmpty());

        //Add product to cart
        AutomationPracticeAddedProductModalPage addedProductModalPage = searchResultPage.addProductToCart("Blouse");

        //Check modal is displayed and product added, then click proceed to check out
        Assert.assertTrue(addedProductModalPage.isProceedToCheckOutButtonPresent());
        Assert.assertEquals(addedProductModalPage.getProductNameOnModal(), "Blouse");
        AutomationPracticeShoppingCartSummary shoppingCartSummary = addedProductModalPage.clickProceedToCheckOutButton();

        //At shopping cart summary, click proceed to check out
        Assert.assertTrue(shoppingCartSummary.isProceedToCheckOutButtonPresent());
        AutomationPracticeSignInPage signInPage = shoppingCartSummary.clickProceedCheckout();

        //Take screenshot of result
        screenshotService.takeScreenshot("signinRequest");

        //Check for sign in request
        Assert.assertTrue(signInPage.isSignInButtonPresent(), "Sign in was not requested");
        Assert.assertTrue(signInPage.isCreateAccountButtonPresent(), "Create an account was not requested");
    }
}
