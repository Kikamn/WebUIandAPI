#Bikin file  ke 1Feature:
Feature: Testing API
  @api
  Scenario: User can get in API
    Given Prepare URL valid for "USER_GOREST"
    And Hit API get list data
    Then Validation status code is equals 200
    Then Validation response body get list user
    Then Validation response json whit JSONSchema "get_list_user.json"

  @api
  Scenario: User can post in API
    Given Prepare URL valid for "USER_GOREST"
    And Hit API Post user
    Then Validation status code is equals 201
    Then Validation response body post create new user
    Then Validation response json whit JSONSchema "post_create_user.json"

  @api
  Scenario: user can update / patch user in API
    Given Prepare URL valid for "USER_GOREST"
    And Hit API Post user
    Then Validation status code is equals 201
    Then Validation response body post create new user
    And Hit API update data
    Then Validation status code is equals 200
    Then Validation response body update user

  @api
  Scenario: user can delete user in API
    Given Prepare URL valid for "USER_GOREST"
    And Hit API Post user
    Then Validation status code is equals 201
    Then Validation response body post create new user
    And Hit API delete new
    Then Validation status code is equals 204






