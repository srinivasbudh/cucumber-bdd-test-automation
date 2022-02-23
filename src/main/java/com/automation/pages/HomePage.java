package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.automation.utils.AssertionUtils.*;
import static com.automation.utils.CommonUtils.clickOnElement;
import static com.automation.utils.CommonUtils.waitAndClick;
import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.WebElementUtils.*;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "btnSingleTrack")
    private WebElement trackBtn;

    @FindBy(css = "a[data-analytics='link|GEO-EN-GB']")
    private WebElement selectCountryBtn;

    @FindBy(xpath = "//button[contains(text(),'ACCEPT ALL COOKIES')]")
    private WebElement acceptCookiesBtn;

    @FindBy(css="li[data-analytics='hero|cube|RATE & SHIP'] .fxg-cube__content")
    private WebElement rateCalculationHeaderMenu;

    /**
     * Method to verify if Home page is Loaded
     */
    public void verifyPageIsLoaded() {
        waitForVisible(trackBtn);
        assertPresent(trackBtn);
    }

    /**
     * Method to Accept cookies after loading
     */
    public void verifyUserAcceptedCookies() {
        waitForVisible(selectCountryBtn);
        clickOnElement(selectCountryBtn);
        acceptCookies();
    }

    private void acceptCookies() {
        if(isElementPresent(acceptCookiesBtn)){
            clickOnElement(acceptCookiesBtn);
        }
    }

    /**
     * Method to Navigate tp rate calculation form
     */
    public void navigateToRateCalculation(){
        waitAndClick(rateCalculationHeaderMenu);
    }

}
