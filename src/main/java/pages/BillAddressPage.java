package pages;

import base.CornerstoneBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillAddressPage extends CornerstoneBase {
    @FindBy(css = "a[aria-controls='addressDropdown']")
    public WebElement addressDropDown;
    public By freeShippingText = By.cssSelector("span[class='shippingOption-desc']");
    public By companyName = By.cssSelector("label#companyInput-label");
    @FindBy(css = "a[data-test='add-new-address']")
    public WebElement newAddress;
    @FindBy(css = "input#firstNameInput")
    public WebElement firstNameInputField;
    @FindBy(css = "input#lastNameInput")
    public WebElement lastNameInputField;
    @FindBy(css = "input[name='shippingAddress.address1']")
    public WebElement addressInputField;

    @FindBy(css = "input#cityInput")
    public WebElement cityInputField;

    @FindBy(css = "input#postCodeInput")
    public WebElement postCodeInputField;

    @FindBy(css = "input#phoneInput")
    public WebElement phoneNumberInput;

    @FindBy(css = "button#checkout-shipping-continue")
    public WebElement continueButton;
    @FindBy(css = ".checkout-step--payment .optimizedCheckout-headingPrimary")
    public WebElement paymentText;

    public BillAddressPage() {
        PageFactory.initElements(driver, this);
    }
}
