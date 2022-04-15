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
    private ExtendedWebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private ExtendedWebElement customerLastName;

    @FindBy(id = "email")
    private ExtendedWebElement email;

    @FindBy(id = "passwd")
    private ExtendedWebElement password;

    //Date of birth
    @FindBy(id = "days")
    private ExtendedWebElement days;

    @FindBy(id = "months")
    private ExtendedWebElement months;

    @FindBy(id = "years")
    private ExtendedWebElement years;

    //YOUR ADDRESS
    @FindBy(id = "firstname")
    private ExtendedWebElement firstName;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastname;

    @FindBy(id = "address1")
    private ExtendedWebElement address1;

    @FindBy(id = "ciry")
    private ExtendedWebElement city;

    @FindBy(id = "id_state")
    private ExtendedWebElement state;

    @FindBy(id = "postcode")
    private ExtendedWebElement zipCode;

    @FindBy(id = "id_country")
    private ExtendedWebElement country;

    @FindBy(id = "phone_mobile")
    private ExtendedWebElement mobilePhone;

    @FindBy(id = "alias")
    private ExtendedWebElement alias;

    @FindBy(id = "submitAccount")
    private ExtendedWebElement register;

    public AutomationPracticeCreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("male")) this.maleGenderRadio.click();
        if(gender.equalsIgnoreCase("female")) this.femaleGenderRadio.click();
    }

    public void fillPersonalFirstName(String name) {
        this.customerFirstName.type(name);
    }

    public void fillPersonalLastName(String lastname) {
        this.customerLastName.type(lastname);
    }

    public void fillEmail (String email) {
        this.email.type(email);
    }

    public void fillPassword(String password) {
        this.password.type(password);
    }

    public void selectBirthDate(int day, int month, int year) {
        this.days.select(day);
        this.months.select(month);
        this.years.select(String.valueOf(year));
    }

    public void fillAddressFirstName(String firstName) {
        this.firstName.type(firstName);
    }

    public void fillAddressLastName(String lastName) {
        this.lastname.type(lastName);
    }

    public void fillAddress(String address) {
        this.address1.type(address);
    }

    public void fillCity(String city) {
        this.city.type(city);
    }

    public void selectState(String state) {
        this.state.select(state);
    }

    public void fillZipCode(String zipCode) {
        this.zipCode.type(zipCode);
    }

    public void fillCountry(String country) {
        this.country.select(country);
    }

    public void fillMobilePhone(String phoneNumber) {
        this.mobilePhone.type(phoneNumber);
    }

    public void fillAlias(String alias){
        this.alias.type(alias);
    }

    public AutomationPracticeHomePage register() {
        this.register.click();
        return new AutomationPracticeHomePage(driver);
    }
}
