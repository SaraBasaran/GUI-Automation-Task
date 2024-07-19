package utility.UI;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static stepdefinitions.Hooks.driver;

public class ReusableMethods {

    /**
     * In this class, methods used in this project are stored and called once the defined methods are required to be used
     * multiple times. Create once use multiple times..)
     * By making the methods public and static these methods can be called from any class of this project.
     */
     public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    public static void waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

      public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForVisibility(element);
    }

    public static void waitForVisibility(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitAndClickWithJS(WebElement element, int timeout) {
        for (int i = 0; i < (timeout * 10); i++) {
            try {
                clickWithJS(element);
                return;
            } catch (WebDriverException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

      public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

}