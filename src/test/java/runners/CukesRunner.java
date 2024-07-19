package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //annotation for CucumberRunner
@CucumberOptions(  //annotation for CucumberOptions
        plugin = {"pretty",                                   // to see the test results on the IDE console
                "html:target/reports/html/html_reports.html", //to see the test results reports in HTML format in target folder
                "json:target/reports/json/json-reports/cucumber.json" // to see the test results reports in JSON format in target folder in JSON format

        },
        features = "src/test/resources/features",            // to give the path to the features package
        glue = "stepdefinitions",                           //to give the path to the stepdefinitions package to glue it with the other packages while running
        tags = ""   // to run a specific test case/s we can assign the tag of test case/s in this case "@US01-TC01_SignUpValid"
                    // or we can leave this tag value empty to run each and every test case in the stepdefinitions package
)

public class CukesRunner {
}