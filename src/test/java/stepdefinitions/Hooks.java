package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utility.ConfigurationReader;
import utility.Driver;
import utility.UI.Utilities;

public class Hooks {

    public static WebDriver driver;
    public static boolean isHeadless = false;
    public static String browserType = ConfigurationReader.getProperty("browserType");

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    public static CommonPage commonPage;
    public static Actions actions;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(order = 1)
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);

        driver.get(ConfigurationReader.getProperty("url"));
        Utilities.waitForPageToLoad(15);
    }



    @After(value = "@US01-TC_01")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
    }
}