package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TryNowPage extends CommonPage{

    // By extending this class to CommonPage, all class data type objects are reachable from the child classes.
    // TryNowPage is the sub/child class of CommonPage abstract class.
    // All selectors/locators related with the TryNowPage are stored in this class under pages package.
    // This way makes codes have atomic structure.
    @FindBy(xpath = "(//a[text()='Try now'])[2]")
    public WebElement tryNowBtn;

    @FindBy(xpath = "(//a[text()='UI for React'])[1]")
    public WebElement tryNowOption;

    @FindBy(xpath ="(//a[@href=\"/try/kendo-react-ui\"])[1]")
    public WebElement tryNowButton;



}
