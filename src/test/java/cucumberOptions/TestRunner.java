package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = {"hooks", "stepDefinitions"},
        plugin = {"pretty", "html:target/CucumberReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@test")

public class TestRunner extends AbstractTestNGCucumberTests {

}
