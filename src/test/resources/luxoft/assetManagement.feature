Feature: Functionalities regarding Asset Management
 
  Scenario: It is possible to open UK Institutional Investors fundpage
    Given I am on UBS homepage
    When I click "Asset Management" dropdown and "UBS Funds" item
    When I choose "Institutional Investors" in "United Kingdom" page
    Then I am on UK fundgate page 
    

    