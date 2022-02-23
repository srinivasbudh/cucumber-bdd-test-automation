package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automation.utils.AssertionUtils.assertNotPresent;
import static com.automation.utils.AssertionUtils.assertPresent;
import static com.automation.utils.CommonUtils.*;
import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.WebElementUtils.*;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "userId")
    private WebElement userIdInput;

    @FindBy(id = "login-btn")
    private WebElement loginBtn;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "fxg-dropdown-signIn")
    private WebElement signUpBtn;

    @FindBy(css="a[data-analytics='link|Log In']")
    private  WebElement loginFromDropDown;

    @FindBy(css="a[title='OPEN A PERSONAL ACCOUNT']")
    private WebElement openPersonalAccountBtn;

    @FindBy(xpath="//div[@class='fdx-utilityWrap']//a[@data-analytics='link|Open an Account']")
    private  WebElement openAccountDropDown;

    @FindBy(id="invalidCredentials")
    private WebElement errorForInvalidCredentials;

    /**
     * Method to navigate to login form
     */
    public void navigateToLoginForm(){
        waitAndClick(signUpBtn);
        waitAndClick(loginFromDropDown);
    }

    /**
     * Method to navigate to open account form
     */
    public void navigateToRegistrationForm(){
        waitAndClick(signUpBtn);
        waitAndClick(openAccountDropDown);
        waitAndClick(openPersonalAccountBtn);
    }

    /**
     * Method to verify if login form is loaded
     */
    public void verifyLoginFormIsLoaded(){
        waitForVisible(loginBtn);
        assertPresent(loginBtn);
    }

    /**
     * Method to login using data supplied in config file
     */
    public void login() {
        sendDataToTextField(userIdInput, getPropertyByKey("username"));
        sendDataToTextField(passwordInput, getPropertyByKey("password"));
        clickOnElement(loginBtn);
    }

    /**
     * Method to login using provided login details
     * @param useId
     * @param password
     */
    public void login(String useId, String password) {
        sendDataToTextField(userIdInput, useId);
        sendDataToTextField(passwordInput, password);
        clickOnElement(loginBtn);
    }

    /**
     * Method to verify if user moved out of login page
     */
    public void assertLoginPageDisappeared(){
        assertNotPresent(loginBtn);
    }

    /**
     * Method to verify errors on Login Form
     */
    public void verifyErrorOnLoginPage(){
        assertPresent(errorForInvalidCredentials);
    }

}
