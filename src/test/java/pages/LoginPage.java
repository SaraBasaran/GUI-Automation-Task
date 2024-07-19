package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  CommonPage{

    @FindBy (id ="email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


}
