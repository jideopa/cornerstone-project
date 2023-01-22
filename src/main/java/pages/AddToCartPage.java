package pages;

import base.CornerstoneBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends CornerstoneBase {
    @FindBy(css = "button[id='quick-search-expand']")
    public WebElement searchInputField;
    @FindBy(css = "[data-test='order-confirmation-order-number-text'] span")
    public WebElement orderConfirmationTextHeading;
    @FindBy(css = "img[alt='Able Brewing System']")
    public WebElement searchItem;

    @FindBy(css = "a[class='button button--small card-figcaption-button']")
    public WebElement addToCartItemHoverButton;

    @FindBy(css = "a[href='/checkout']")
    public WebElement checkOutButton;
    @FindBy(css = "button[aria-label='Price']")
    public WebElement priceText;

    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }
}
