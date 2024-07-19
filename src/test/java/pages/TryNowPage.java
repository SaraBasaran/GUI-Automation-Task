package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TryNowPage extends CommonPage{

    @FindBy(xpath = "(//a[text()='Try now'])[1]")
    public WebElement tryNowBtn;

    @FindBy(xpath = "(//a[text()='UI for React'])[1]")
    public WebElement uiForReactSelect;



}
