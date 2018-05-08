@Feature
Feature: ModifyItem Validation
 
Background:
   Given user is on SummerDressesPage   

Scenario Outline:  ModifyItem validations
    Given user has selected a dress
    When user changes the colour of dress to Blue
    Then add the item to the cart