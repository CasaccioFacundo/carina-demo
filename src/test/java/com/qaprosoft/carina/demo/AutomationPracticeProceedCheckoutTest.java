package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeProceedCheckoutTest implements IAbstractTest {

    @Test()
    public void testProceedCheckoutWithoutLogin() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Search for product and check products were found
        AutomationPracticeSearchResultPage searchResultPage = homePage.searchProduct("blouse");
        Assert.assertTrue(searchResultPage.allElementListsAreNotEmpty());

        //Add product to cart and check if added
        AutomationPracticeAddedProductModalPage addedProductModalPage = searchResultPage.addProductToCart("blouse");
        Assert.assertTrue(addedProductModalPage.isCartNotEmpty());

        //Check modal displayed correctly and click proceed to check out
        Assert.assertTrue(addedProductModalPage.isProceedToCheckOutButtonPresent());
        AutomationPracticeShoppingCartSummary shoppingCartSummary = addedProductModalPage.clickProceedToCheckOutButton();

        //At shopping cart summary, click proceed to check out and check for request sign in page
        Assert.assertTrue(shoppingCartSummary.isProceedToCheckOutButtonPresent());
        AutomationPracticeSignInPage signInPage = shoppingCartSummary.clickProceedCheckout();
        Assert.assertTrue(signInPage.isSignInButtonPresent(), "Sign in was not requested");
        Assert.assertTrue(signInPage.isCreateAccountButtonPresent(), "Create an account was not requested");
    }
}
