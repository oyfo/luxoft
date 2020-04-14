Feature: Functionalities regarding main page
 
  Scenario: It is possible to switch to German
    Given I am on UBS homepage
    When I click on 'switch to German' button
    Then I should be directed to 'https://www.ubs.com/global/de.html'
    
	Scenario: It is possible to switch to English
    Given I am on German Home UBS page 
    When I click on 'switch to English' button
    Then I should be directed to 'https://www.ubs.com/global/en.html'