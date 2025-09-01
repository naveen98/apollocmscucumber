Feature: CMS Login

  @smoke
  Scenario: Login with valid credentials and see CMS label
    Given I am on the CMS login page
    When I login using valid credentials
    Then I should see the CMS home page

  @smoke
  Scenario: User selects Apollo CMS app
    Given user is on the App Selection page
    When user clicks on the Apollo CMS app
    Then Apollo CMS app should be displayed