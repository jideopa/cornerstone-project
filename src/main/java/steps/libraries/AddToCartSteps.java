package steps.libraries;

import base.CornerstoneBase;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddToCartPage;
import pages.BillAddressPage;
import pages.PaymentPage;
import pojos.CreditCard;
import utils.DataGenerator;

import java.time.Duration;

@Log4j2

public class AddToCartSteps extends CornerstoneBase {
    private AddToCartPage addToCartPage = new AddToCartPage();
    private CommonSteps commonSteps = new CommonSteps();

    private BillAddressPage billAddressPage = new BillAddressPage();

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));

    private PaymentPage paymentPage = new PaymentPage();

    public void searchForItem(String searchQuery) {
        addToCartPage.searchInputField.click();
        addToCartPage.searchInputField.sendKeys(searchQuery, Keys.ENTER);
    }

    public void selectItem() {
        commonSteps.waitForElementToBeClickable(addToCartPage.searchItem);
        commonSteps.scrollDownToElement(addToCartPage.searchItem);
        commonSteps.waitForElementToBeClickable(addToCartPage.priceText);
        commonSteps.mouseHover(addToCartPage.searchItem);
        addToCartPage.addToCartItemHoverButton.click();

    }

    public void addItemToCart() {
        commonSteps.waitForElementToBeClickable(addToCartPage.checkOutButton);
        commonSteps.scrollDownToElement(addToCartPage.checkOutButton);
        addToCartPage.checkOutButton.click();

    }

    public void billingAddress() {
        DataGenerator dataGenerator = DataGenerator.getInstance();
        wait.until(ExpectedConditions.visibilityOfElementLocated(billAddressPage.freeShippingText));
        billAddressPage.addressDropDown.click();
        billAddressPage.newAddress.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(billAddressPage.companyName));
        billAddressPage.firstNameInputField.sendKeys(dataGenerator.faker.name().firstName());
        billAddressPage.lastNameInputField.sendKeys(dataGenerator.faker.name().lastName());
        billAddressPage.addressInputField.sendKeys(dataGenerator.faker.address().fullAddress());
        billAddressPage.cityInputField.sendKeys(dataGenerator.faker.address().city());
        billAddressPage.postCodeInputField.sendKeys(dataGenerator.faker.address().zipCode());
        billAddressPage.phoneNumberInput.sendKeys(dataGenerator.faker.phoneNumber().cellPhone());
        commonSteps.scrollDownToElement(billAddressPage.paymentText);
        commonSteps.waitForElementToBeClickable(billAddressPage.continueButton);
        billAddressPage.continueButton.click();
    }

    public void completePaymentForm() {
        CreditCard card = new CreditCard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPage.gatewayText));
        paymentPage.creditCardNumberInputField.sendKeys(card.getCreditCardNumber());
        paymentPage.creditCardExpiryDateInputField.sendKeys(card.getExpiration());
        paymentPage.cardNameInputField.sendKeys(card.getNameOnCard());
        paymentPage.creditCvvInputField.sendKeys(card.getCvv());
        commonSteps.scrollDownToElement(paymentPage.placeOrderButton);
        commonSteps.waitForElementToBeClickable(paymentPage.placeOrderButton);
        paymentPage.placeOrderButton.click();

    }

    public boolean orderNumberIsDisplay() {
        wait.until(ExpectedConditions.visibilityOf(addToCartPage.orderConfirmationTextHeading));
        log.info(addToCartPage.orderConfirmationTextHeading.getText());
        return addToCartPage.orderConfirmationTextHeading.isDisplayed();
    }
}
