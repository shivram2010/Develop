@Feature
Feature: Login
 
Background:
   Given application is launched on "chrome" browser   
@invalid
Scenario Outline:  Login with valid credentials
    Given site <url>
    When user clicks on sign in
    Then user enters <email> id
    And create account
    Then user should get user exception
 		Examples:
      |email   |     
      |shivram |
      |123     |
 
 
@valid 
Scenario Outline:  Login with valid credentials
    Given site <url>
    When user clicks on sign in
    Then user enters <email> id
    And create account
    Then user should redirect to registration page
 		Examples:
      |url                                    |email            |     
      |http://automationpractice.com/index.php|vvashi@gmail.com |
      |http://automationpractice.com/index.php|kashi@gmail.com  |