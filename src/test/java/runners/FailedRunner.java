package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",  //allows us to see the pretty output of the test result on IDE console
                "html:target/reports/html/failed_cucumber-html_reports.html",  //once a test case fails this command cretaes and htmk formatted report giving explanations about the failed test case under target/reports folder
                "json:target/reports/json/failed_json-reports/cucumber.json",  //once a test case fails this command cretaes and json file formatted report giving explanations about the failed test case under target/reports folder
                "junit:target/reports/xml/failed_xml-report/cucumber.xml"     //once a test case step fails this command cretaes and xml file formatted report giving explanations about the failed test case under target/reports folder
        },
        features = "@target/reports/rerun.txt", // this command will re-run the failed test case under the reports folder
        glue = ""                               //default way of glue process is done
)

public class FailedRunner {
}