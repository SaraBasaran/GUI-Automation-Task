package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TryNowPage extends CommonPage{

    @FindBy(xpath = "//span[@class=\"Dropdown-arrow\"]")
    public WebElement tryNowBtn;

    @FindBy(xpath = "(//a[text()='UI for React'])[1]")
    public WebElement uiForReactSelect;

    @FindBy(xpath ="(//a[@href=\"/try/kendo-react-ui\"])[1]")
    public WebElement tryNowButton;



}
