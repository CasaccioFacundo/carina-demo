package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeContactPage extends AbstractPage {

    @FindBy(id = "id_contact")
    private ExtendedWebElement subjectHeading;

    @FindBy(id = "email")
    private ExtendedWebElement emailAddress;

    @FindBy(id = "id_order")
    private ExtendedWebElement orderReference;

    @FindBy(id = "message")
    private ExtendedWebElement message;

    @FindBy(id = "submitMessage")
    private ExtendedWebElement send;

    public AutomationPracticeContactPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubjectHeading(String subjectHeading) {
        this.subjectHeading.select(subjectHeading);
    }

    public void fillEmail(String email) {
        this.emailAddress.type(email);
    }

    public void fillOrderReference(String orderReference) {
        this.orderReference.type(orderReference);
    }

    public void writeMessage(String message) {
        this.message.type(message);
    }

    public AutomationPracticeContactControllerPage sendMessage() {
        this.send.click();
        return new AutomationPracticeContactControllerPage(driver);
    }


}
