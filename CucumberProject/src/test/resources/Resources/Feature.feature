Feature: Verifying Flexifunnels page

  Scenario Outline: Verifying flexifunnels login page
    Given User is on the loginpage
    When User should login "<username>","<password>"
    Then User should create new project

    Examples: 
      | username              | password   |
      | ashokdhasan@gmail.com | flexi@321# |
