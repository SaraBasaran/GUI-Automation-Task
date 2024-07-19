package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  CommonPage{

    // By extending this class to CommonPage, all class data type objects are reachable from the child classes.
    // LoginPage is the sub/child class of CommonPage abstract class.
    // All selectors/locators related with the LoginPage are stored in this class under pages package.
    // This way makes codes have atomic structure.
    @FindBy (id ="email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


}
