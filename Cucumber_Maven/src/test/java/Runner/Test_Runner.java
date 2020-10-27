package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features={"src/test/resources/Login/Login.feature"},
glue={"StepDefinition"},
//tags="@negative", //will run only specific scenario or whole scenarios then put @tagname for the specific scenario or feature
dryRun=false, //To check running to find out did I miss any step
monochrome=true,// to make console output to be displayed in proper format 
strict=true,//it will check any steps in the feature file is missing in the implementation
plugin={"html:testout/dhanya.html", "junit:testout/cucumber.xml", "json:testout/cucumber.json"}
		)
public class Test_Runner {

}
