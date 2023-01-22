package pages;

import base.CornerstoneBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CornerstoneBase {
    @FindBy(css ="input#ccNumber")
    public WebElement creditCardNumberInputField;

    @FindBy(css = "input#ccExpiry")
    public WebElement creditCardExpiryDateInputField;

    @FindBy(css = "input#ccName")
    public WebElement cardNameInputField;

    @FindBy(css = "input#ccCvv")
    public WebElement creditCvvInputField;

    @FindBy(css = "button#checkout-payment-continue")
    public WebElement placeOrderButton;

    public By gatewayText = By.cssSelector(".paymentProviderHeader-nameContainer > .paymentProviderHeader-name");

    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }
}
