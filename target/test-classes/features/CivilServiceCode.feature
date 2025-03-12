Feature: CivilServiceCode

  Background:
    Given user navigate to civil service jobs
    When user clicks verify protected by ALTCHA checkbox
    And user clicks continue button
    And user clicks accept additional cookies

    @test
  Scenario: Validate Civil Service Code link redirects to the section of the Civil Service Commission website
    When user clicks careers available in the civil service link
    Then civil service careers page displayed
    When user clicks accept cookies
    And user clicks life in the civil service dropdown
    And user clicks working for the civil service
    And user clicks civil service code link
    Then civil service commission code session displayed
