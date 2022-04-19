package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeCreateAccountPage extends AbstractPage {

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "id_gender1")
    private ExtendedWebElement maleGenderRadio;

    @FindBy(id = "id_gender2")
    private ExtendedWebElement femaleGenderRadio;

    @FindBy(id = "customer_firstname")
    private ExtendedWebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private ExtendedWebElement customerLastNameInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "passwd")
    private ExtendedWebElement passwordInput;

    //Date of birth
    @FindBy(id = "days")
    private ExtendedWebElement daysSelect;

    @FindBy(id = "months")
    private ExtendedWebElement monthsSelect;

    @FindBy(id = "years")
    private ExtendedWebElement yearsSelect;

    //YOUR ADDRESS
    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastnameInput;

    @FindBy(id = "address1")
    private ExtendedWebElement address1Input;

    @FindBy(id = "ciry")
    private ExtendedWebElement cityInput;

    @FindBy(id = "id_state")
    private ExtendedWebElement stateSelect;

    @FindBy(id = "postcode")
    private ExtendedWebElement zipCodeInput;

    @FindBy(id = "id_country")
    private ExtendedWebElement countryInput;

    @FindBy(id = "phone_mobile")
    private ExtendedWebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private ExtendedWebElement aliasInput;

    @FindBy(id = "submitAccount")
    private ExtendedWebElement registerButton;

    public AutomationPracticeCreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("male")) maleGenderRadio.click();
        if(gender.equalsIgnoreCase("female")) femaleGenderRadio.click();
    }

    public void fillPersonalFirstName(String name) {
        customerFirstNameInput.type(name);
    }

    public void fillPersonalLastName(String lastname) {
        customerLastNameInput.type(lastname);
    }

    public void fillEmail (String email) {
        emailInput.type(email);
    }

    public void fillPassword(String password) {
        passwordInput.type(password);
    }

    public void selectBirthDate(int day, int month, int year) {
        daysSelect.select(day);
        monthsSelect.select(month);
        yearsSelect.select(String.valueOf(year));
    }

    public void fillAddressFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    public void fillAddressLastName(String lastName) {
        lastnameInput.type(lastName);
    }

    public void fillAddress(String address) {
        address1Input.type(address);
    }

    public void fillCity(String city) {
        cityInput.type(city);
    }

    public void selectState(String state) {
        stateSelect.select(state);
    }

    public void fillZipCode(String zipCode) {
        zipCodeInput.type(zipCode);
    }

    public void fillCountry(String country) {
        countryInput.select(country);
    }

    public void fillMobilePhone(String phoneNumber) {
        mobilePhoneInput.type(phoneNumber);
    }

    public void fillAlias(String alias){
        aliasInput.type(alias);
    }

    public AutomationPracticeHomePage clickRegisterButton() {
        registerButton.click();
        return new AutomationPracticeHomePage(driver);
    }
}
