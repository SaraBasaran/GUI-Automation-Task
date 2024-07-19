package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utility.ConfigurationReader;
import static java.lang.Integer.parseInt;
import static stepdefinitions.Hooks.actions;
import static stepdefinitions.Hooks.driver;
import static utility.UI.Utilities.*;

public class SignUpValid extends CommonPage {

    Faker faker= new Faker();
    String fakeEmail= faker.internet().emailAddress();

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

        scrollToElement(getTryNowPage().tryNowBtn);
        getTryNowPage().tryNowBtn.click();
        String downloadPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(downloadPageUrl, ConfigurationReader.getProperty("tryNowUrl"));

        actions.sendKeys(Keys.ARROW_DOWN).perform();
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

        getCreateAccountPage().passwordInputBox.sendKeys(ConfigurationReader.getProperty("valid_password"));
        getCreateAccountPage().firstNameInputBox.sendKeys(faker.name().firstName());
        getCreateAccountPage().lastNameInputBox.sendKeys(faker.name().lastName());
        getCreateAccountPage().companyInputBox.sendKeys(faker.company().name());
        getCreateAccountPage().phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());

    }

    @And("I select {string} from the Country of Residence dropdown list")
    public void ıSelectStringFromTheCountryOfResidenceDropdownList(String arg0) {
        getCreateAccountPage().countryDropdown.click();
        getCreateAccountPage().countryDropdown.sendKeys(ConfigurationReader.getProperty("countryName"));
    }

    @And("I select {string} option from Businees Need input")
    public void ıSelectStringOptionFromBusineesNeedInput() {
        getCreateAccountPage().bussinessNeedDropdown.click();
        Select select =new Select(getCreateAccountPage().lookingForTestToolOpt);
        select.selectByVisibleText(ConfigurationReader.getProperty("selectOptForBussNeed"));
    }

    @And("I click on {string} button")
    public void ıClickOnButton(String arg0) {
        getCreateAccountPage().createAccBtn.click();
    }
}