package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeContactPage;
import com.qaprosoft.carina.demo.gui.pages.AutomationPracticeHomePage;
import com.qaprosoft.carina.demo.utils.AuthService;
import com.qaprosoft.carina.demo.utils.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeContactTest implements IAbstractTest {

    AuthService authService = new AuthService();
    ScreenshotService screenshotService = new ScreenshotService();

    @Test()
    public void testContactForm() {
        //Open homepage and verify it opened correctly
        AutomationPracticeHomePage homepage = new AutomationPracticeHomePage(getDriver());
        homepage.open();
        Assert.assertTrue(homepage.isPageOpened(), "Home page is not opened");

        //Navigate to contact page
        AutomationPracticeContactPage contactPage = homepage.goToContactPage();

        //Fill contact form and submit
        contactPage.selectSubjectHeading("Customer service");
        contactPage.fillEmail(authService.generateRandomEmail());
        contactPage.fillOrderReference("112983");
        contactPage.writeMessage("Test message");
        contactPage.clickSendMessage();

        //Take screenshot of result
        screenshotService.takeScreenshot();

        //Verify alert of message successfully sent
        Assert.assertTrue(contactPage.getMessageAlert(), "Failed to send message");
    }
}
