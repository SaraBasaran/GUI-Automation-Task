package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utility.UI.ConfigurationReader;
import utility.UI.Driver;
import utility.UI.ReusableMethods;

public class Hooks {

    // In this class we configure WebDriver object.
    public static WebDriver driver;  //WebDriver instance resourced from Selenium.
    public static boolean isHeadless = true;  // to set the driver headless for testing on cloud browsers
    public static String browserType = ConfigurationReader.getProperty("browserType"); // to reach the data in configuration.properties file
                                                                                       // and use it as a dynamic browser type

    public static boolean isFullScreen = true; //setting the screen size to full screen size mode
    public static int width;
    public static int height;

    public static CommonPage commonPage;
    public static Actions actions;

    @Before(value = "@headless", order = 0)       //to run test scripts with chrome and in "headless mode" to run test scripts on cloud machine.
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)        //to run test scripts with firefox browser as browserType variable
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(order = 1)
    public void setup() {  //to get the driver and start driver before any tests

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);

        driver.get(ConfigurationReader.getProperty("url")); //whatever the "url" property value is set that value will be assigned to get the driver
        ReusableMethods.waitForPageToLoad(15);
    }



    @After(value = "")                        //this code runs after every test case/feature file scenario and if
                                              // the test case fails Selenium WebDriver takes ss of the failed test case.
                                              // if required we can assign "tag" of specific test case to see if the test case fails
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
       // driver.quit(); //closes all open tab/tabs of the browser
    }
}