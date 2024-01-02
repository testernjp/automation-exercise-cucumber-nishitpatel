@regression
Feature: As a user,
  I should login successfully with correct email and password
  I should not login successfully with incorrect email and password
  I should logout successfully

  #Test Case 2: Login User with correct email and password
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click on 'Signup / Login' button
#        5. Verify 'Login to your account' is visible
#        6. Enter correct email address and password
#        7. Click 'login' button
#        8. Verify that 'Logged in as username' is visible
#        9. Click 'Delete Account' button
#        10. Verify that 'ACCOUNT DELETED!' is visible

  @author_NP @sanity @smoke
  Scenario: User should login with correct email and password
    Given I am on homepage
    When  I click on 'Signup/Login' button
    And I should see the text Login to your account
    And I enter "scooper@gmail.com" email and "sc2023" password
    And I click on Login button
    Then I verify that Logged in as username is visible
    And I click Delete Account button
    Then I verify that text ACCOUNT DELETED! is visible

    #Test Case 3: Login User with incorrect email and password
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click on 'Signup / Login' button
#        5. Verify 'Login to your account' is visible
#        6. Enter incorrect email address and password
#        7. Click 'login' button
#        8. Verify error 'Your email or password is incorrect!' is visible

  @author_NP @smoke
  Scenario: User should not login successfully with incorrect email and password
    Given I am on homepage
    When  I click on 'Signup/Login' button
    And I should see the text Login to your account
    And I enter "sheldon2023@gmail.com" email and "sc2023" password
    And I click on Login button
    And I should see the login page text "Your email or password is incorrect!"

  #Test Case 4: Logout User
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click on 'Signup / Login' button
#        5. Verify 'Login to your account' is visible
#        6. Enter correct email address and password
#        7. Click 'login' button
#        8. Verify that 'Logged in as username' is visible
#        9. Click 'Logout' button
#        10. Verify that user is navigated to login page

  @author_NP
  Scenario: Logout User
    Given I am on homepage
    When  I click on 'Signup/Login' button
    And I should see the text Login to your account
    And I enter "sc2023@gmail.com" email and "sc2023" password
    And I click on Login button
    Then I verify that Logged in as username is visible
    And I click on logout button
    And I am navigated to login page