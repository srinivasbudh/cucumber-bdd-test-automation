package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.RateCalculationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RateCalculationSteps {
    HomePage homePage = new HomePage();
    RateCalculationPage rateCalculationPage = new RateCalculationPage();


    @And("^He attempts to calculate shipping price between (.*) and (.*) cities$")
    public void rateCalculation(String fromCity, String toCity) throws Throwable {
        homePage.navigateToRateCalculation();
        rateCalculationPage.verifyPageIsLoaded();
        rateCalculationPage.enterRateCalculationDetails(fromCity,toCity);
    }

    @When("^For a packaging (.*) with single package$")
    public void selectPackageType(String boxType) throws Throwable {
        rateCalculationPage.selectBagType(boxType);
    }

    @Then("^Approximate rates along with delivery dates are displayed$")
    public void verifyRateSummary() throws Throwable {
        rateCalculationPage.verifyRateCalculationDetailsAreDisplayed();
    }

}
