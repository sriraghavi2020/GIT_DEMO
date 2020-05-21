package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Kiriti\\eclipse-workspace\\Cucumber_Target\\src\\main\\java\\Features\\login.feature",
		glue = {"Step_Definition"},
		plugin = {"pretty", "html:test-output", "junit:junit_xml/junitoutput.xml", "json:json_output/cucumber.json"},
		monochrome = true,
		dryRun = false,
		tags = {"@Hooks"}
		
		)


public class LoginPage_TestRunner {
	
}
