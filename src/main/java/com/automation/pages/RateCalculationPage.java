package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automation.utils.AssertionUtils.assertPresent;
import static com.automation.utils.CommonUtils.*;
import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.WebElementUtils.*;

public class RateCalculationPage {
    public RateCalculationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "input[data-e2e-id='fromGoogleAddress']")
    private WebElement fromAddress;

    @FindBy(css = "input[data-e2e-id='toGoogleAddress']")
    private WebElement toAddress;

    @FindBy(xpath = "//ul[@id='e2eGoogleAddressSuggestionList']//li[1]")
    public WebElement fromAddressList;

    @FindBy(id="package-details__package-type")
    public WebElement packageDetailsDroDown;

    @FindBy(id="package-details__weight-0")
    public WebElement packageWeightText;

    @FindBy(id="e2ePackageDetailsSubmitButtonRates")
    public WebElement showRatesButtons;

    @FindBy(id="rateSummary")
    public WebElement rateCalculationData;

    /**
     * Method to verify if rate calculation page is loaded
     */
    public void verifyPageIsLoaded() {
        waitForVisible(fromAddress);
        assertPresent(fromAddress);
    }

    /**
     * Method to innput Origin and destination for rate calculation
     * @param from Origin city
     * @param to Destination city
     */
    public void enterRateCalculationDetails(String from, String to){
        selectFromAddressDropdown(fromAddress,from);
        selectFromAddressDropdown(toAddress,to);
    }

    /**
     * Method to select baggage type for rate calculation
     * @param bagType Type of baggae value from dropdown in rate calculation
     */
    public void selectBagType(String bagType){
        clickOnElement(packageDetailsDroDown);
        selectValueFromDropDown(packageDetailsDroDown,bagType);
        sendDataToTextField(packageWeightText,"1");
        waitAndClick(showRatesButtons);
    }

    /**
     * Method to select city from city drop down suggestion in rate calclation form
     * @param element on which this method needs to be applied
     * @param location city name
     */
    public void selectFromAddressDropdown(WebElement element,String location) {
        sendDataToTextField(element,location);
        waitForElementToBeClickable(fromAddressList);
        makeExecutionWait();
        WebElement button = createDynamicLocator("//ul[@id='e2eGoogleAddressSuggestionList']//li[1]","");
        clickOnElement(button);
    }

    /**
     * Method to verify Rate summary is displayed as expected
     */
    public void verifyRateCalculationDetailsAreDisplayed(){
        assertPresent(rateCalculationData);
    }


}
