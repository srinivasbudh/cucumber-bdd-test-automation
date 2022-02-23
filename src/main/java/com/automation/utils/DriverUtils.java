package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static com.automation.utils.ConfigUtils.loadProperties;

/**
 * Author : Srinivas Budha
 * DriverUtils: Utility methods for invoking webdriver instance
 */
public class DriverUtils {
    static WebDriver driver;

    public static void initDriver() throws Exception{
        loadProperties();
        String browser = getPropertyByKey("browser");
        String operatingSystem = System.getProperty("os.name");

        if(operatingSystem.toUpperCase().contains("WINDOWS"))
            selectBrowserDriverForWindows(browser);
        else
            selectBrowserDriverForMac(browser);

        navigateToAppURL();
    }

    public static void navigateToAppURL() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getPropertyByKey("application.url"));
    }

    public static void selectBrowserDriverForMac(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }

    public static void selectBrowserDriverForWindows(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }


    public static WebDriver getDriver() {

        if (driver == null ) {
            try {
                initDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
