package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import utility.UI.ConfigurationReader;
import java.time.Duration;
import static stepdefinitions.Hooks.actions;
import static stepdefinitions.Hooks.driver;
import static utility.UI.ReusableMethods.*;

public class SignUpValid extends CommonPage {

    Faker faker= new Faker();

    @Given("I am on the Telerik website")
    public void ı_am_on_the_telerik_website() {
        waitForPageToLoad(3);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ConfigurationReader.getProperty("url"));
    }

    @When("I click on Get A Free Trial button")
    public void ı_click_on_get_a_free_trial_button() {
        waitForPageToLoad(3);
        waitAndClickWithJS( getHomePage().freeTrialBtn, 3);
    }

    @And("I should see {string} and select {string} option from Try Now dropdown list")
    public void ıShouldSeeAndSelectOptionFromTryNowDropdownList(String planOption, String tryOption) {
        waitForPageToLoad(3);
        planOption=ConfigurationReader.getProperty("planOption"); //getting the value "Kendo UI Plan" from config properties
        tryOption= ConfigurationReader.getProperty("tryNowOption"); //getting the value "Kendo UI Try Now" from config properties
        String downloadPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(downloadPageUrl, ConfigurationReader.getProperty("tryNowUrl"));
        driver.getPageSource().contains(planOption);

        scrollToElement(getTryNowPage().tryNowBtn);
        actions.sendKeys(Keys.DOWN).perform();
        clickWithJS(getTryNowPage().tryNowBtn);

        clickWithJS(getTryNowPage().tryNowOption);
        getTryNowPage().tryNowButton.click();
    }

    @When("I enter valid email and click on Next button")
    public void ıEnterValidEmailAndClickOnNextButton() throws InterruptedException {
        String loginUrl= driver.getCurrentUrl();
        Assert.assertTrue(loginUrl.contains(ConfigurationReader.getProperty("loginOrSignUpPageUrl")));
        getCreateAccountPage().simulateHumanTyping(getLoginPage().emailInputBox, ConfigurationReader.getProperty("valid_email"));
        waitForClickability(getLoginPage().submitButton,2);
        getLoginPage().submitButton.click();
    }

    @And("I enter valid password, First Name and Last Name Company, Phone")
    public void ıEnterValidPasswordFirstNameAndLastNameCompanyPhone()  {
        //we can pass data by using files like configuration.properties or we can use an excel sheet to retrieve test data
        // or to have always "new usable and valid data" we can use java Faker class objects to produce fake name, fake email, etc.
        waitForPageToLoad(3);
        String createAccPageUrl= driver.getCurrentUrl();
        Assert.assertTrue(createAccPageUrl.contains(ConfigurationReader.getProperty("createAccountUrl")));
        getCreateAccountPage().passwordInputBox.sendKeys(ConfigurationReader.getProperty("valid_password"));
        getCreateAccountPage().firstNameInputBox.sendKeys(faker.name().firstName());
        getCreateAccountPage().lastNameInputBox.sendKeys(faker.name().lastName());
        getCreateAccountPage().companyInputBox.sendKeys(faker.company().name());
        getCreateAccountPage().phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());
    }

    @And("I select {string} from the Country of Residence dropdown list")
    public void ıSelectFromTheCountryOfResidenceDropdownList(String country) {
        //getting the value "Egypt" from config properties and using it in the test case
        country= ConfigurationReader.getProperty("countryName");
        scrollToElement(getCreateAccountPage().countryDropdownSelectListBtn);
        waitAndClickWithJS(getCreateAccountPage().countryDropdownSelectListBtn, 3);
        //adding explicit wait to interact with the webelement and actually does not wait 5 seconds
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getCreateAccountPage().countryInputBoxArea));
        waitAndClickWithJS(getCreateAccountPage().countryInputBoxArea, 3);
        getCreateAccountPage().countryInputBoxArea.sendKeys(country);
    }

    @And("I select {string} option from Business Need input")
    public void ıSelectOptionFromBusinessNeedInput(String businessNeedOption)  {
        //getting the value "Testing Tool" from config properties and using it in the test case
        businessNeedOption=ConfigurationReader.getProperty("businessNeedOption");
        getCreateAccountPage().bussinessNeedDropdown.click();
        waitAndClickWithJS(getCreateAccountPage().lookingForTestToolOpt, 5);
    }

    @And("I click on Create account button")
    public void ı_click_on_create_account_button() {
        scrollToElement(getCreateAccountPage().createAccBtn);
        getCreateAccountPage().createAccBtn.click();
        waitAndClickWithJS(getCreateAccountPage().humanCFcheckbox, 5);
        waitForPageToLoad(5);

        String signUpSuccessMsg= getCreateAccountPage().thankYouMsg.getText();
        driver.getPageSource().contains(signUpSuccessMsg);
    }
}


