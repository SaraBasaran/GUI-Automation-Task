package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

    @FindBy (xpath = "//a[@href=\"/download\"]")
    public WebElement freeTrialBtn;

    @FindBy(xpath = "//div[@data-tlrk-plugin=\"dropdown\"]")
    public WebElement tryNowBtn;

    @FindBy(xpath = "//button[text()='Accept Cookies']")
    public WebElement cookieAcceptBtn;



}
