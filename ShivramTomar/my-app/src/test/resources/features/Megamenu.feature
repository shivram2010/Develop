@Feature
Feature: MegaMenu Validation
 
Background:
   Given application is launched on "chrome" browser   

Scenario Outline:  Megamenu validations
    Given site <url>
    When user clicks on MegaMenu
    AND user navigates to Dresses
    AND user clicks on SummerDresses
    Then user is on SummerDressespage