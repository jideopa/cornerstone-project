package pages;

import base.CornerstoneBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CornerstoneBase {
    @FindBy(css = "[value='Sign in']")
    public WebElement signButton;

    @FindBy(css = "input#login_email")
    public WebElement emailInputField;

    @FindBy(css = "input#login_pass")
    public WebElement passwordInputField;

    @FindBy(css = ".navUser-item--account [aria-label='Account']")
    public WebElement accountButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
