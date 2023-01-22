package steps.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.libraries.AddToCartSteps;

public class AddToCartStepDefinition {
    AddToCartSteps addToCartSteps = new AddToCartSteps();
    @Given("user search for {string}")
    public void userSearchFor(String searchQuery) {
        addToCartSteps.searchForItem(searchQuery);
    }

    @And("add item is add to cart")
    public void addItemIsAddToCart() {
        addToCartSteps.selectItem();
        addToCartSteps.addItemToCart();
    }

    @When("user complete the checkout process")
    public void userCompleteTheCheckoutProcess() {
        addToCartSteps.billingAddress();
        addToCartSteps.completePaymentForm();
    }

    @Then("order confirmation is display to customer")
    public void orderConfirmationIsDisplayToCustomer() {
        Assert.assertTrue(addToCartSteps.orderNumberIsDisplay());
        addToCartSteps.orderNumberIsDisplay();
    }
}
