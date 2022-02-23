package com.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.WebElementUtils.waitForVisible;

/**
 * Author : Srinivas Budha
 * Common Utils : Utility methods for commonly used methods for automation
 */

public class CommonUtils {
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,250)");
    }

    public static void clickOnElement(WebElement element) {
        waitForVisible(element);
        element.click();
    }

    public static void sendDataToTextField(WebElement element, String text){
        waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    public static void waitAndClick(WebElement element){
        waitForVisible(element);
        clickOnElement(element);
    }
}
