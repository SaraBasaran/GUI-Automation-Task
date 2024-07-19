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

    @When("I should see Kendo UI Plan and select UI for React option from Try Now dropdown list")
    public void ı_should_see_kendo_uı_plan_and_select_uı_for_react_option_from_try_now_dropdown_list() {
        waitForPageToLoad(3);
        String downloadPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(downloadPageUrl, ConfigurationReader.getProperty("tryNowUrl"));
        scrollToElement(getTryNowPage().tryNowBtn);
        actions.sendKeys(Keys.DOWN).perform();
        clickWithJS(getTryNowPage().tryNowBtn);
        clickWithJS(getTryNowPage().uiForReactSelect);
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
        System.out.println("createAccPageUrl = " + createAccPageUrl);
        Assert.assertTrue(createAccPageUrl.contains(ConfigurationReader.getProperty("createAccountUrl")));
        getCreateAccountPage().passwordInputBox.sendKeys(ConfigurationReader.getProperty("valid_password"));
        getCreateAccountPage().firstNameInputBox.sendKeys(faker.name().firstName());
        getCreateAccountPage().lastNameInputBox.sendKeys(faker.name().lastName());
        getCreateAccountPage().companyInputBox.sendKeys(faker.company().name());
        getCreateAccountPage().phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());
    }

    @When("I select Egypt from the Country of Residence dropdown list")
    public void ı_select_egypt_from_the_country_of_residence_dropdown_list() {
        scrollToElement(getCreateAccountPage().countryDropdownSelectListBtn);
        waitAndClickWithJS(getCreateAccountPage().countryDropdownSelectListBtn, 3);
        //adding explicit wait to interact with the webelement and actually does not wait 5 seconds
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getCreateAccountPage().countryInputBoxArea));
        waitAndClickWithJS(getCreateAccountPage().countryInputBoxArea, 3);
        getCreateAccountPage().countryInputBoxArea.sendKeys(ConfigurationReader.getProperty("countryName"));
    }

    @When("I select Looking for a Testing Tool option from Business Need input")
    public void ı_select_looking_for_a_testing_tool_option_from_business_need_input() {
        getCreateAccountPage().bussinessNeedDropdown.click();
        waitAndClickWithJS(getCreateAccountPage().lookingForTestToolOpt, 5);
    }

    @And("I click on Create account button")
    public void ı_click_on_create_account_button() {
        scrollToElement(getCreateAccountPage().createAccBtn);
        getCreateAccountPage().createAccBtn.click();
    }
}


