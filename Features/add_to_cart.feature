@regression
Feature: Add to cart
  Background:
    Given a user has logged in

  Scenario: Success purchase
    Given user search for "Able Brewing System"
    And add item is add to cart
    When user complete the checkout process
    Then  order confirmation is display to customer