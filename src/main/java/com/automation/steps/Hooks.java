package com.automation.steps;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.BeforeClass;

import static com.automation.utils.DriverUtils.getDriver;
import static com.automation.utils.DriverUtils.tearDown;

/**
 * Author: Srinivas Budha
 * Hooks to setup before and after actions
 */
public class Hooks {

    @Before
   public void setUp() {
        getDriver();
    }

    @After
    public void teardown(){
       tearDown();
    }
}
