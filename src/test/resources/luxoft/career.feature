Feature: Careers
  Tests regarding items in Carrerrs dropdown menu

  Scenario Outline: 
    Given I am on UBS homepage
    When I click "Careers" dropdown and "Search jobs" item
    And I chose careers for professionals in "<region>"
    And I save number of all offers
    And I search for "QA" and "Poland"
    Then number of filtered results shhould be smaller
  
  Examples: 
      | region  	| 
      | Europe, Middle East, Africa (excl. Switzerland)	|