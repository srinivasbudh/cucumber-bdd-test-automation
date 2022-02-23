package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automation.utils.AssertionUtils.assertPresent;
import static com.automation.utils.CommonUtils.*;
import static com.automation.utils.DriverUtils.getDriver;


public class TrackingModulePage {
    public TrackingModulePage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(css=".notification__message")
    private WebElement trackErrorMessage;

    @FindBy(css="input[name='trackingnumber']")
    private WebElement trackingNumberTxt;

    @FindBy(id = "btnSingleTrack")
    private WebElement trackBtn;

    @FindBy(css=".fxg-mouse img[alt='Search']")
    private WebElement searchIcon;

    @FindBy(id="fxg-search-text")
    public  WebElement trackingNumberSearchTxt;

    @FindBy(id="fxg-search-icon")
    public  WebElement searchTrackingNumber;

    @FindBy(css="a[data-analytics='hdr|tab|2|Tracking']")
    public  WebElement trackingMenuOption;

    @FindBy(id="trackingModuleTrackingNum")
    public WebElement TrackingNumberMenuText;

    @FindBy(css="button[data-analytics='hdr|tab2|Track']")
    public WebElement searchTrackingMenuOption;

    /**
     * Method for tracking the shipment from tracking option on Home page
     * @param trackingNumber
     */
   public void searchForTrackingNumberFromHomePage(String trackingNumber){
       sendDataToTextField(trackingNumberTxt,trackingNumber);
       waitAndClick(trackBtn);
   }

    /**
     * Method for tracking the shipment from tracking option on from search option in top right corner
     * @param trackingNumber
     */
    public void searchForTrackingNumberFromSearch(String trackingNumber){
       waitAndClick(searchIcon);
       sendDataToTextField(trackingNumberSearchTxt,trackingNumber);
        waitAndClick(searchTrackingNumber);
    }

    /**
     * Method for tracking the shipment from tracking option on menu option under tracking menu
     * @param trackingNumber
     */
    public void searchForTrackingNumberFromMenu(String trackingNumber){
        waitAndClick(trackingMenuOption);
        sendDataToTextField(TrackingNumberMenuText,trackingNumber);
        waitAndClick(searchTrackingMenuOption);
    }

    /**
     * Method to verify error on tracking Id
     */
    public void verifyTrackErrorMessageIsDisplayed(){
        assertPresent(trackErrorMessage);
    }


}
