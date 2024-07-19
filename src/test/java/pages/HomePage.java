package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

    // By extending this class to CommonPage, all class data type objects are reachable from the child classes.
    // HomePage is the sub/child class of CommonPage abstract class.
    // All selectors/locators related with the HomePage are stored in this class under pages package.
    // This way makes codes have atomic structure.

    @FindBy (xpath = "//a[@href=\"/download\"]")
    public WebElement freeTrialBtn;

    @FindBy(xpath = "//div[@data-tlrk-plugin=\"dropdown\"]")
    public WebElement tryNowBtnAtHp;

    @FindBy(css = "#onetrust-accept-btn-handler")
    public WebElement cookieAcceptBtn;



}
