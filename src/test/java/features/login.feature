Feature: CMS Login

  @smoke @regression
  Scenario: Login with valid credentials and see CMS label
    Given I am on the CMS login page
    When I login using valid credentials
    Then I should see the CMS home page

  @smoke @regression
  Scenario: User selects Apollo CMS app
    Given user is on the App Selection page
    When user clicks on the Apollo CMS app
    Then Apollo CMS app should be displayed

  @smoke @regression
  Scenario: Navigate to Pine Lab Issues page from sidebar
    Given I am logged into the CMS and on the CMS home page
    When I navigate to Pine Lab Issues from the sidebar
    Then the Pine Lab Issues page should be visible

  @smoke
  Scenario: Create new Pine Lab Issues from Excel
    Given I am on the Pine Lab Issues page
    When I create new issues from Excel test data

  @regression
  Scenario: Update Pine Lab Issue details from Excel
    When I update Pine Lab Issue details from Excel test data
    Then I should see the update confirmation
