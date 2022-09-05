package com.leaseplandigital.qa.implementations.frontend.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class ConfiureAEM {

    @FindBy(id="coral-id-1090")
    private WebElementFacade automationTag;

    @FindBy(xpath="//button[@data-foundation-command-label='Edit']")
    private WebElementFacade editButton;

    @FindBy(xpath="//div[@data-path='/content/fedex-com/sites/mi/en_mi/automation/jcr:content/root/responsivegrid/*']")
    private WebElementFacade dragComponentGrid;

    @FindBy(xpath="//button[@data-action='INSERT']")
    private WebElementFacade plusButton;

    @FindBy(xpath="//input[@placeholder='Enter Keyword']")
    private WebElementFacade searchComponent;

    @FindBy(xpath="//coral-selectlist-item[contains(text(),'FedEx - Guided Navigation')]")
    private WebElementFacade selectGuidedNavigationFromList;

    @FindBy(xpath="//div[@title='FedEx - Guided Navigation']")
    private WebElementFacade guidedNavigationHeader;

    @FindBy(xpath="//button[@data-action='CONFIGURE']")
    private WebElementFacade configureButton;

    @FindBy(xpath="//input[@name='./title']")
    private WebElementFacade titleInput;

    @FindBy(xpath="//input[@name='./viewAllLabel']")
    private WebElementFacade viewAllLabelInput;

    @FindBy(xpath="//input[@name='./backToLabel']")
    private WebElementFacade backToLabelInput;

    @FindBy(xpath="//input[@name='./backToMainTopicsLabel']")
    private WebElementFacade backToMainTopicsLabelInput;

    @FindBy(xpath="//label[contains(text(),'Category Tags')]/following-sibling::foundation-autocomplete//button")
    private WebElementFacade categoriesTag;

    @FindBy(id="coral-id-1080")
    private WebElementFacade faqTag;

    @FindBy(id="coral-id-1090")
    private WebElementFacade dutiesAndTaxesTag;

    @FindBy(id="coral-id-1109")
    private WebElementFacade NamesTags; // Todo tags for all components

    @FindBy(xpath="//coral-button-label[contains(text(),'Select')]")
    private WebElementFacade selectTagsButton;

    @FindBy(xpath="//button[@icon=\"check\" and @title='Done']")
    private WebElementFacade submitForm;

    @FindBy(xpath="//coral-icon[@icon='properties']")
    private WebElementFacade propertiesButton;

    @FindBy(xpath="//button[@trackingelement='publish page']")
    private WebElementFacade publishPage;


    public void navigateToEditTab(){
        automationTag.waitUntilVisible().then().click();
        String oldTab = getDriver().getWindowHandle();
        editButton.waitUntilVisible().then().click();
        ArrayList<String> newTab = new ArrayList<String>(getDriver().getWindowHandles());
        newTab.remove(oldTab);
    }

    public void insertGuidedNavigationComponent(){
        dragComponentGrid.waitUntilVisible().then().click();
        plusButton.waitUntilVisible().then().click();
        searchComponent.waitUntilVisible().isVisible();
        selectGuidedNavigationFromList.waitUntilVisible().click();
    }

    public void fillTheLabels(String titleValue, String viewAllLabelValue){
        titleInput.waitUntilVisible().sendKeys(titleValue);
        viewAllLabelInput.waitUntilVisible().sendKeys();
        backToLabelInput.waitUntilVisible().sendKeys();
        backToMainTopicsLabelInput.waitUntilVisible().sendKeys();
    }

    public void publishThePage(){
        propertiesButton.waitUntilVisible().then().click();
        publishPage.waitUntilVisible().then().click();
    }




}
