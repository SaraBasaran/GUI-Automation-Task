package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class CreateAccountPage extends CommonPage{
    // By extending this class to CommonPage, all class data type objects are reachable from the child classes.
    // CreateAccountPage is the sub/child class of CommonPage abstract class.
    // All selectors/locators related with the CreateAccountPage are stored in this class under pages package.
    // This way makes codes have atomic structure.

    @FindBy(css = "input#password")
    public WebElement passwordInputBox;

    @FindBy(id="fist-name")
    public WebElement firstNameInputBox;

    @FindBy(id="last-name")
    public WebElement lastNameInputBox;

    @FindBy(id="company")
    public WebElement companyInputBox;

    @FindBy(id="phone")
    public WebElement phoneInputBox;

    @FindBy(xpath = "(//button[@aria-label=\"Select\"])[1]")
    public WebElement countryDropdownSelectListBtn;

    @FindBy(xpath="(//input[@aria-haspopup=\"listbox\"])[1]")
    public WebElement countryInputBoxArea;

    @FindBy(id="business-need")
    public WebElement bussinessNeedDropdown;

    @FindBy(xpath="(//span[@class=\"k-list-item-text\"])[5]")
    public WebElement lookingForTestToolOpt;

    @FindBy(xpath="//*[text()='Create Account']")
    public WebElement createAccBtn;

    public void simulateHumanTyping(WebElement webElement, String input) throws InterruptedException {
    // code snippet to handle grecaptcha bots.
        Random r = new Random();

        for (int i = 0; i < input.length(); i++) {
            try {
                Thread.sleep((int) r.nextGaussian() * 10 + 100);
            } catch (InterruptedException e) {
            }
            String s = new StringBuilder().append(input.charAt(i)).toString();
            webElement.sendKeys(s);
        }
    }
}
