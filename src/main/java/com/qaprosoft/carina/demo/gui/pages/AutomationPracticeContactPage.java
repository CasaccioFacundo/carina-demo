package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeContactPage extends AbstractPage {

    @FindBy(id = "id_contact")
    private ExtendedWebElement subjectHeadingSelect;

    @FindBy(id = "email")
    private ExtendedWebElement emailAddressInput;

    @FindBy(id = "id_order")
    private ExtendedWebElement orderReferenceInput;

    @FindBy(id = "message")
    private ExtendedWebElement messageInput;

    @FindBy(id = "submitMessage")
    private ExtendedWebElement sendButton;

    @FindBy(xpath = "//p[text()='Your message has been successfully sent to our team.']")
    private ExtendedWebElement successfulMessageAlert;

    public AutomationPracticeContactPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubjectHeading(String subjectHeading) {
        subjectHeadingSelect.select(subjectHeading);
    }

    public void fillEmail(String email) {
        emailAddressInput.type(email);
    }

    public void fillOrderReference(String orderReference) {
        orderReferenceInput.type(orderReference);
    }

    public void writeMessage(String message) {
        messageInput.type(message);
    }

    public void clickSendMessage() {
        sendButton.click();
    }


}
