Feature:SearchForJobOpenings

  @test
  Scenario Outline: Validate user can search for job openings
    Given user navigate to civil service jobs
    When user clicks verify protected by ALTCHA checkbox
    And user clicks continue button
    And user clicks accept additional cookies
    When user enters job title, skill or keywords "<Title>"
    And user enters a postcode, town or region "<Region>"
    And user clicks search for jobs button
    Then search results listing relevant jobs appear
    When user clicks department to filter
    And user enters medicine in "<SearchField>"
    And user clicks to select the medicines and healthcare product regulatory agency checkbox
    And user clicks update results
    Then number of jobs available displayed

   Examples:
    |    Title   |   Region | SearchField |
    |  Analyst   |   London  | Medicine   |



