Feature: Login with parameters

@librarianpara
  Scenario: As a librarian, I should be able to login the web page

  Given user is on the login page
  When I enter username "librarian1@library"
  And I enter password "rs4BNN9G"
  And click the sign in button
  And there should be "173" users
  Then user should see the dashboard

  #number can be whatever you have there

  @studentpara
  Scenario: As a student, I should be able to login the web page


    When user enter "student1@library" to the username input box
    And user enter "i2A9TgXa" to the password input box
    Then user should see the book dashboard