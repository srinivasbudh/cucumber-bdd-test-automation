package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.pages.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
    LoginPage loginpage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();


    @When("^He attempts to login using (.*) (.*) and (.*)$")
    public void login(String userType,String userName, String password) throws Throwable {
        loginpage.navigateToLoginForm();
        loginpage.verifyLoginFormIsLoaded();
        loginpage.login(userName,password);
    }

    @Then("^user login (.*) successful$")
    public void verifyLogin(String loginStatus) throws Throwable {
        if("is".equalsIgnoreCase(loginStatus))
            loginpage.assertLoginPageDisappeared();
        else
            loginpage.verifyErrorOnLoginPage();

    }

    @When("^he attempts register with (.*) details for (.*)$")
    public void userRegistration(String userType, String countryCode) throws Throwable {
        loginpage.navigateToRegistrationForm();
        registrationPage.verifyPageIsLoaded();
        registrationPage.defaultRegister(userType,countryCode);
        if("valid".equalsIgnoreCase(userType))
            registrationPage.createUserId("sampleId1238","SampleTest9876");
    }

    @When("^user (.*) successfully registered$")
    public void userRegistrationVerification(String registrationStatus) throws Throwable {
        if("is".equalsIgnoreCase(registrationStatus))
            registrationPage.userIdCreationIsSuccessful();
        else
            registrationPage.verifyPageIsLoaded();
    }


}
