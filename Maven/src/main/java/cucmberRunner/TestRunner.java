package cucmberRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features"
		,glue={"stepDefinition"}
		,plugin={"html:target/pension-age-report",
				"json:target/cucumber.json",
				 "com.infostretch.qmetrytestmanager.result.TestExecution"
		)
 
public class TestRunner {
 
}
