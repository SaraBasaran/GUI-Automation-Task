package utility.UI;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Driver;
import static java.time.Duration.ofSeconds;
import static stepdefinitions.Hooks.actions;
import static stepdefinitions.Hooks.driver;

public class Utilities {

    public static void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

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

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void sendText(WebElement element, String text) {
        try {
            waitForClickability(element, 15).sendKeys(text);
        } catch (ElementNotInteractableException e) {
            scrollToElement(element);
            sendText(element, text);
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForVisibility(element);
    }

    public static void waitForVisibility(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < (timeout * 10); i++) {
            try {
                element.click();
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
    public static void deleteAllCookies() {
        driver.manage().deleteAllCookies();

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

    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < (timeout * 10); i++) {
            try {
                element.sendKeys(text);
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

    public static void setAttribute(WebDriver driver, WebElement element, String attributeName, String attributeValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, attributeName, attributeValue);
    }

}