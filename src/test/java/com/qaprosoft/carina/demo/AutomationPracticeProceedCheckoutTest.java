package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeProceedCheckoutTest implements IAbstractTest {

    @Test()
    public void testProceedCheckoutWithoutLoggin() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //Search for product and check products were found
        AutomationPracticeSearchResultPage searchResultPage = homePage.searchProduct("blouse");
        Assert.assertTrue(searchResultPage.allElementListsAreNotEmpty());

        //Add product to cart and proceed checkout
        AutomationPracticeAddedProductModalPage addedProductModalPage = searchResultPage.addProductToCart("blouse");
        AutomationPracticeShoppingCartSummary shoppingCartSummary = addedProductModalPage.clickProceedToCheckOutButton();

        //At shopping cart summary, click proceed to checkout and check for request signin page
        AutomationPracticeSignInPage signInPage = shoppingCartSummary.clickProceedCheckout();
        Assert.assertEquals(signInPage.getSignInButton(), "Sign in");
        Assert.assertEquals(signInPage.getCreateAccountButton(), "Create an account");
    }
}
