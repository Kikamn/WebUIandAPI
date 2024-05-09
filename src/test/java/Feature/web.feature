Feature: Testing Web

  @web
  Scenario:Login with username and password correct
    Given User in login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    When User click button login
    Then userCanLogin

  @web
  Scenario: Login with username and password empty
    Given User in login page
    And User input username ""
    And User input password ""
    When User click button login
    Then Will show error "Epic sadface: Username is required"

  @web
  Scenario: Login with username invalid and password valid
    Given User in login page
    And User input username "kika_mn"
    And User input password "secret_sauce"
    When User click button login
    Then Will show error "Epic sadface: Username and password do not match any user in this service"
      
  @web
  Scenario: Login With username valid and password invalid
    Given User in login page
    And User input username "standard_user"
    And User input password "kika123"
    When User click button login
    Then Will show error "pic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Login with username empty and password valid
    Given User in login page
    And User input username ""
    And User input password "secret_sauce"
    When User click button login
    Then Will show error "Epic sadface: Username is required"

  @web
  Scenario: Login with username valid and password empty
    Given User in login page
    And User input username "standard_user"
    And User input password ""
    When User click button login
    Then Will show error "Epic sadface: Password is required"

  @web
  Scenario: Check Burgermenu in Swag Labs
    Given User in login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    And User click button login
    And User click button Burgermenu
    Then Will show menu in Burgermenu

  @web
  Scenario: Check filter in Swag Labs
    Given User in login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    And User click button login
    And User click filer
    Then Will chose menu in filter

  @web
  Scenario: User can click button add to cart
    Given User in login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    And User click button login
    And User click button addtocart
    Then Can click button addtocart

  @web
  Scenario: User can click button remove
    Given User in login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    And User click button login
    And User click button addtocart
    And User click button remove
    Then Will back to button addtocart








      
      
      
    
    






