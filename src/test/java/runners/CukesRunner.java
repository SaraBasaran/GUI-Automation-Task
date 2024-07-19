package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/reports/html/html_reports.html",
                "json:target/reports/json/json-reports/cucumber.json",
                "rerun:target/reports/rerun.txt"
        },
        features = "src/test/resources/features/uiFeatures",
        glue = "stepDefs",
        tags = ""
)

public class CukesRunner {
}