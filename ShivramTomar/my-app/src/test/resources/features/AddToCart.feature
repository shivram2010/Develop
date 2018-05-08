@Feature
Feature: AddToCart Validation
 
Background:
   Product is selected 

Scenario Outline:  AddToCart validations
    Given user clicks on AddToCart
    When user validates Name
    AND user validates Color
    AND user validates Quantity
    Then Name is correct
    AND Color is correct
    AND Quantity is correct