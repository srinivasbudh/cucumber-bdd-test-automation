package runner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features = {"src/test/java/features"},
        glue = {"com.automation.steps"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}
)
public class TestRunner {
    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setProjectName("Test Automation Report");
        extentProperties.setReportPath("output/testReport.html");
    }
}