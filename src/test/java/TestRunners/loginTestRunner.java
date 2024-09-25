package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src/test/resources/features/loginn.feature"},
glue= {"StepDefinitions"},
plugin= {"pretty","html:target/htmlLoginReport.html"}, monochrome=true)


public class loginTestRunner extends AbstractTestNGCucumberTests
{

}
