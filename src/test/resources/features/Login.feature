@run
Feature: Library app login feature

  User story:
  As a user, I should be able to login with correct credentials to different accounts

  Background: Assuming user is on the login page
   Given user is on the login page

@librarian @employee
  Scenario: As a librarian, I should be able to login the web page

    When user login is as librarian
    Then user should see the dashboard

  @student
  Scenario: As a student, I should be able to login the web page

    When user login as student
    Then user should see the book dashboard