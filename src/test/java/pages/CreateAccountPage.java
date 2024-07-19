package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class CreateAccountPage extends CommonPage{

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

    @FindBy(id="country")
    public WebElement countrySelectBox;

    @FindBy(css=".k-searchbar")
    public WebElement countryDropdown;

    @FindBy(id="cb580104-4bec-4696-808a-0b5f6fea29f8")
    public WebElement bussinessNeedDropdown;

    public void simulateHumanTyping(WebElement webElement, String input) throws InterruptedException {

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
