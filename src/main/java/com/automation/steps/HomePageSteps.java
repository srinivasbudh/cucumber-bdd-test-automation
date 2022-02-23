package com.automation.steps;

import com.automation.pages.HomePage;
import cucumber.api.java.en.Given;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Given("^A user is accessing Fedex portal$")
    public void accessPortal() throws Throwable {
        homePage.verifyPageIsLoaded();
        homePage.verifyUserAcceptedCookies();
    }

}
