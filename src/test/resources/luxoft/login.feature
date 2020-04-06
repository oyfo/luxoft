Feature: Login to UBS
  Tests regarding login feature to differen UBS accounts

  Scenario Outline: US client account login - wrong credentials
    Given I am on UBS homepage
    When I click on 'UBS logins' button
    And I click on 'US client account login'
    And I enter incorrect login "<login>" and password "<password>"
    Then I should see warning notification
  
  Examples: 
      | login  	| password 	|
      | user1 	|	pass3 		| 
      | pas			| zxxx 			|