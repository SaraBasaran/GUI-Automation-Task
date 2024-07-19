package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import utility.ConfigurationReader;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static stepdefinitions.Hooks.actions;
import static stepdefinitions.Hooks.driver;
import static utility.UI.Utilities.*;

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
//        getHomePage().cookieAcceptBtn.click();
        String downloadPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(downloadPageUrl, ConfigurationReader.getProperty("tryNowUrl"));
        scrollToElement(getTryNowPage().tryNowBtn);
        actions.sendKeys(Keys.DOWN).perform();
        clickWithJS(getTryNowPage().tryNowBtn);
        clickWithJS(getTryNowPage().uiForReactSelect);

    }

    @When("I enter valid email and click on Next button")
    public void ıEnterValidEmailAndClickOnNextButton() throws InterruptedException {
        getTryNowPage().tryNowButton.click();
        getCreateAccountPage().simulateHumanTyping(getLoginPage().emailInputBox, ConfigurationReader.getProperty("valid_email"));
        waitForClickability(getLoginPage().submitButton,10);
        getLoginPage().submitButton.click();
    }

    @And("I enter valid password, First Name and Last Name Company, Phone")
    public void ıEnterValidPasswordFirstNameAndLastNameCompanyPhone()  {

        waitForPageToLoad(3);
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
        //adding explicit wait to interact with the webelement
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getCreateAccountPage().countryInputBoxArea));
        waitAndClickWithJS(getCreateAccountPage().countryInputBoxArea, 3);
        getCreateAccountPage().countryInputBoxArea.sendKeys(ConfigurationReader.getProperty("countryName"));
    }

  @When("I select Looking for a Testing Tool option from Businees Need input")
    public void ı_select_looking_for_a_testing_tool_option_from_businees_need_input() {
        getCreateAccountPage().bussinessNeedDropdown.click();
        Select select =new Select(getCreateAccountPage().lookingForTestToolOpt);
        select.selectByVisibleText(ConfigurationReader.getProperty("selectOptForBussNeed"));
    }

    @When("I click on Create account button")
    public void ı_click_on_create_account_button() {
        getCreateAccountPage().createAccBtn.click();
    }
}


