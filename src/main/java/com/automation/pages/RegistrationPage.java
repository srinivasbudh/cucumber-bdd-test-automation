package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automation.utils.AssertionUtils.*;
import static com.automation.utils.CommonUtils.*;
import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.WebElementUtils.*;


public class RegistrationPage {
    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css="input[autocomplete='given-name']")
    private  WebElement firstNameText;

    @FindBy(css="input[autocomplete='family-name']")
    private  WebElement lastNameText;

    @FindBy(id="company")
    private  WebElement companyText;

    @FindBy(id="country")
    private  WebElement countryText;

    @FindBy(id="address")
    private WebElement addressLineOneTxt;

    @FindBy(id="additional-street-line")
    private WebElement additionalStreetTxt;

    @FindBy(id="postal-code")
    private WebElement postalCodeTxt;

    @FindBy(id="city")
    private WebElement cityTxt;

    @FindBy(id="email")
    private WebElement emailTxt;

    @FindBy(id="phone")
    private WebElement phoneTxt;

    @FindBy(css="button[data-test-id='contactFormSubmitButton']")
    private WebElement submitRegistrationBtn;

    @FindBy(css="button[data-test-id='signupFormSubmitButton']")
    private WebElement createUserIdButton;

    @FindBy(css="button[data-test-id='accountTypeSubmitButton']")
    private WebElement openMyAccountButton;

    @FindBy(css="label[for='userIdTypeOption']")
    private  WebElement userIdTypeRadioBtn;

    @FindBy(css="label[for='acceptPrivacyPolicyAndTermsAndConditions']")
    private  WebElement acceptConditionsBtn;

    @FindBy(id="userId")
    private  WebElement userIdTxt;

    @FindBy(id="password")
    private  WebElement passwordTxt;

    @FindBy(id="confirmPassword")
    private  WebElement confirmPasswordTxt;

    @FindBy(css="#toast-container")
    private WebElement countryChangeAlert;


    /**
     * Method to verify Registration page is loaded
     */
    public void verifyPageIsLoaded(){
        waitForVisible(firstNameText);
        assertPresent(firstNameText);
    }

    /**
     * Method to provide all the required details to complete registration
     * @param firstName
     * @param lastName
     * @param companyValue
     * @param countryValue
     * @param addressLineOneValue
     * @param addressLineStreetValue
     * @param postCodeValue
     * @param cityValue
     * @param phoneValue
     * @param emailValue
     */
    public void register(String firstName, String lastName, String companyValue, String countryValue, String addressLineOneValue, String addressLineStreetValue, String postCodeValue, String cityValue, String phoneValue, String emailValue){
        sendDataToTextField(firstNameText,firstName);
        sendDataToTextField(lastNameText,lastName);
        sendDataToTextField(companyText,companyValue);
        selectCounty(countryValue);
        sendDataToTextField(addressLineOneTxt,addressLineOneValue);
        sendDataToTextField(additionalStreetTxt,addressLineStreetValue);
        sendDataToTextField(postalCodeTxt,postCodeValue);
        sendDataToTextField(cityTxt,cityValue);
        sendDataToTextField(phoneTxt,phoneValue);
        sendDataToTextField(emailTxt,emailValue);
        submitContactDetails();
    }

    private void submitContactDetails() {
        waitForNotVisible(countryChangeAlert);
        waitForElementToBeClickable(submitRegistrationBtn);
        clickOnElement(submitRegistrationBtn);
    }


    private void selectCounty(String countryValue) {
        selectValueFromDropDown(countryText,countryValue);
    }

    /**
     * Method to create UserId for registered user
     * @param idValue Id of choice
     * @param passwordValue password of choice
     */
   public void createUserId(String idValue,String passwordValue){
        waitAndClick(userIdTypeRadioBtn);
        sendDataToTextField(userIdTxt,idValue);
        sendDataToTextField(passwordTxt,passwordValue);
        sendDataToTextField(confirmPasswordTxt,passwordValue);
        submitUserId();
   }

    private void submitUserId() {
        clickOnElement(acceptConditionsBtn);
        waitForElementToBeClickable(createUserIdButton);
    }

    /**
     * Method to verify userId creation is successful
     */
    public void userIdCreationIsSuccessful(){
        assertClickable(createUserIdButton);
    }

    /**
     * Method to register with default values based on userType
     * @param userType valid or invalid usr
     * @param userCountry country code as per drop down value
     */
    public void defaultRegister(String userType, String userCountry){
        register(getPropertyByKey(userType+"firstName"),getPropertyByKey(userType+"lastName"),getPropertyByKey("company"),userCountry,getPropertyByKey("address"),getPropertyByKey("addressStreet"),getPropertyByKey("postalCode"),getPropertyByKey("city"),getPropertyByKey(userType+"phoneNumber"),getPropertyByKey(userType+"email"));
    }


}
