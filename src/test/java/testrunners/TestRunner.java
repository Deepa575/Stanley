package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/StanleyLogin.feature"},
		glue = {"com.vassarlabs.stanley.pages","com.vassarlabs.stanley.tests","setups"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-report.html","json:target/json-report.json"
				,"timeline:test-output/"
				},
		monochrome = true
		
		)

public class TestRunner {

}
