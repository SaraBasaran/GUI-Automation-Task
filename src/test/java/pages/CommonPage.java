package pages;

import org.openqa.selenium.support.PageFactory;
import static stepdefinitions.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private TryNowPage tryNowPageObj;
    private LoginPage loginPageObj;
    private CreateAccountPage createAccountPageObj;

    public HomePage getHomePage() {
        if (homePage == null){
            homePage = new HomePage();
        }
        return homePage;  // return the instance of Homepage class thus we do not to create a new instance in every needed test class.
    }

    public TryNowPage getTryNowPage() {
        if (tryNowPageObj == null){
            tryNowPageObj = new TryNowPage();
        }
        return tryNowPageObj;  // return the instance of TryNowPage class
    }

    public LoginPage getLoginPage() {
        if (loginPageObj == null){
            loginPageObj = new LoginPage();
        }
        return loginPageObj;  // return the instance of LoginPage class
    }

    public CreateAccountPage getCreateAccountPage() {

        if (createAccountPageObj == null){
            createAccountPageObj=new CreateAccountPage();
        }
        return createAccountPageObj;  // return the instance of CreateAccountPage class
        }
}