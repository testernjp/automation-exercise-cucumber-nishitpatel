@regression
Feature: As a user,
  I should register successfully
  I should see error message while register with existing email
  I should Place Order: Register while Checkout
  I should Place Order: Register before Checkout
  I should Place Order: Login before Checkout
  I should verify address details in checkout page

  #Test Case 1: Register User
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click on 'Signup / Login' button
#        5. Verify 'New User Signup!' is visible
#        6. Enter name and email address
#        7. Click 'Signup' button
#        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
#        9. Fill details: Title, Name, Email, Password, Date of birth
#        10. Select checkbox 'Sign up for our newsletter!'
#        11. Select checkbox 'Receive special offers from our partners!'
#        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
#        13. Click 'Create Account button'
#        14. Verify that 'ACCOUNT CREATED!' is visible
#        15. Click 'Continue' button
#        16. Verify that 'Logged in as username' is visible
#        17. Click 'Delete Account' button
#        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

  @author_NP  @sanity @smoke
  Scenario: Register New User Account
    Given I am on homepage
    When I click on 'Login' button
    Then Verify New User Signup! is visible
    And I enter "Sheldon" in the name and enter "scooper" in the email address
    And I click on Signup button
    And Verify the text ENTER ACCOUNT INFORMATION is visible
    And I select radiobutton Title "Mr" and I enter Name "Sheldon" and I enter Email "scooper@gmail.com" and I enter Password "sc2023" and I enter Date of Birth as Day "1" Month "January" Year "1990"
    And I select the checkbox for Sign up for our newsletter!
    And I select the checkbox for Receive special offers from our partners!
    And I enter first name "Sheldon"
    And I enter last name "Cooper"
    And I enter company "Coopers"
    And I enter Address "New Society"
    And I enter Addresstwo "University Road"
    And I enter country "India"
    And I enter state "Gujarat"
    And I enter City "Rajkot"
    And zipcode "360001"
    And mobile number "98989856561"
    And I click Create Account button
    Then I verify that ACCOUNT CREATED! is visible
    And I click Continue button
    Then I verify that Logged in as username is visible
    And I click Delete Account button
    Then I verify that text ACCOUNT DELETED! is visible and click Continue button

    #Test Case 5: Register User with existing email
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click on 'Signup / Login' button
#        5. Verify 'New User Signup!' is visible
#        6. Enter name and already registered email address
#        7. Click 'Signup' button
#        8. Verify error 'Email Address already exist!' is visible

  @author_NP @smoke
  Scenario: User should see error message while register with existing email
    Given I am on homepage
    When  I click on 'Signup/Login' button
    Then Verify New User Signup! is visible
    And I enter "Sheldon" in the name and  I enter "sc2023@gmail.com" in the email address
    And I click on Signup button
    Then I should see error message Email Address already exist!

    #Test Case 14: Place Order: Register while Checkout
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Add products to cart
#        5. Click 'Cart' button
#        6. Verify that cart page is displayed
#        7. Click Proceed To Checkout
#        8. Click 'Register / Login' button
#        9. Fill all details in Signup and create account
#        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
#        11. Verify ' Logged in as username' at top
#        12.Click 'Cart' button
#        13. Click 'Proceed To Checkout' button
#        14. Verify Address Details and Review Your Order
#        15. Enter description in comment text area and click 'Place Order'
#        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
#        17. Click 'Pay and Confirm Order' button
#        18. Verify success message 'Your order has been placed successfully!'
#        19. Click 'Delete Account' button
#        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

  @author_NP
  Scenario: User should Place Order: Register while Checkout
    Given I am on homepage
    When I add product "Blue Top" to the cart
    And I click on view cart in popup
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I click on register link in the checkout popup
    And I send name "Amy" and email "amy" to signup
    And I click on button "Signup"
    And I fill all details in signup page "Mrs" "amy@123" "1" "January" "1990" "Amy" "Santiago" "Rugby Avenue" "University Road" "India" "Gujarat" "Rajkot" "360001" "09984766666"
    And I click on Create Account button
    Then I see account created message "ACCOUNT CREATED!"
    And I click on continue button
    Then I should see the text "Logged in as " "Amy"
    And I click on header menu option "Cart"
    And I click on Proceed to Checkout button
    And I should see the text on checkout page "Review Your Order"
    And I should see the text on checkout page "Address Details"
    And I enter details into comment area "Please deliver it on time."
    And I click on place order button
    And I enter payment details "Jack Peralta" "4263982640269299" "837" "02" and "2026"
    And I click on Pay and Confirm Order button
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
    And I click on header menu option "Delete Account"
    Then I should see the account deleted message "ACCOUNT DELETED!"
    Then I click on continue button after deleting account

    #Test Case 15: Place Order: Register before Checkout
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click 'Signup / Login' button
#        5. Fill all details in Signup and create account
#        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
#        7. Verify ' Logged in as username' at top
#        8. Add products to cart
#        9. Click 'Cart' button
#        10. Verify that cart page is displayed
#        11. Click Proceed To Checkout
#        12. Verify Address Details and Review Your Order
#        13. Enter description in comment text area and click 'Place Order'
#        14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
#        15. Click 'Pay and Confirm Order' button
#        16. Verify success message 'Your order has been placed successfully!'
#        17. Click 'Delete Account' button
#        18. Verify 'ACCOUNT DELETED!' and click 'Continue' button

  @author_NP
  Scenario: User should Place Order: Register before Checkout
    Given I am on homepage
    When I click on header menu option "Signup / Login"
    And I send name "Amy" and email "amy" to signup
    And I click on button "Signup"
    And I fill all details in signup page "Mrs" "amy@123" "1" "January" "1990" "Amy" "Santiago" "Rugby Avenue" "University Road" "India" "Gujarat" "Rajkot" "360001" "09584766666"
    And I click on Create Account button
    Then I see account created message "ACCOUNT CREATED!"
    And I click on continue button
    Then I should see the text "Logged in as " "Amy"
    And I add product "Blue Top" to the cart
    And I click on view cart in popup
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I should see the text on checkout page "Review Your Order"
    And I should see the text on checkout page "Address Details"
    And I enter details into comment area "Please deliver it on time."
    And I click on place order button
    And I enter payment details "Jack Peralta" "4263982640269299" "837" "02" and "2026"
    And I click on Pay and Confirm Order button
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
    And I click on header menu option "Delete Account"
    Then I should see the account deleted message "ACCOUNT DELETED!"
    Then I click on continue button after deleting account

    #Test Case 16: Place Order: Login before Checkout
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click 'Signup / Login' button
#        5. Fill email, password and click 'Login' button
#        6. Verify 'Logged in as username' at top
#        7. Add products to cart
#        8. Click 'Cart' button
#        9. Verify that cart page is displayed
#        10. Click Proceed To Checkout
#        11. Verify Address Details and Review Your Order
#        12. Enter description in comment text area and click 'Place Order'
#        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
#        14. Click 'Pay and Confirm Order' button
#        15. Verify success message 'Your order has been placed successfully!'
#        16. Click 'Delete Account' button
#        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

  @author_NP
  Scenario: User should place the order successfully : Login before Checkout
    Given I am on homepage
    When I click on header menu option "Signup / Login"
    Then I should see the login page text "Login to your account"
    And I enter "scooper123@gmail.com" email and "sc2023" password for login
    And I click on button "Login"
    Then I should see the text "Logged in as " "Sheldon"
    And I add product "Blue Top" to the cart
    And I click on view cart in popup
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I should see the text on checkout page "Review Your Order"
    And I should see the text on checkout page "Address Details"
    And I enter details into comment area "Please deliver it on time."
    And I click on place order button
    And I enter payment details "Jack Peralta" "4263982640269299" "837" "02" and "2026"
    And I click on Pay and Confirm Order button
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
    And I click on header menu option "Logout"

    #Test Case 23: Verify address details in checkout page
#        1. Launch browser
#        2. Navigate to url 'http://automationexercise.com'
#        3. Verify that home page is visible successfully
#        4. Click 'Signup / Login' button
#        5. Fill all details in Signup and create account
#        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
#        7. Verify ' Logged in as username' at top
#        8. Add products to cart
#        9. Click 'Cart' button
#        10. Verify that cart page is displayed
#        11. Click Proceed To Checkout
#        12. Verify that the delivery address is same address filled at the time registration of account
#        13. Verify that the billing address is same address filled at the time registration of account
#        14. Click 'Delete Account' button
#        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button

  @author_NP
  Scenario: Verify address details in checkout page
    Given I am on homepage
    When I click on header menu option "Signup / Login"
    And I send name "Amy" and email "amy" to signup
    And I click on button "Signup"
    And I fill all details in signup page "Mrs" "amy@123" "1" "January" "1990" "Amy" "Santiago" "Rugby Avenue" "University Road" "India" "Gujarat" "Rajkot" "360001" "09584766666"
    And I click on Create Account button
    Then I see account created message "ACCOUNT CREATED!"
    And I click on continue button
    Then I should see the text "Logged in as " "Amy"
    And I add product "Blue Top" to the cart
    And I click on view cart in popup
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    Then I should see the delivery address is same address filled at the time registration of account "Rugby Avenue"
    And I should see billing address is same address filled at the time registration of account "Rugby Avenue"
    And I click on header menu option "Delete Account"
    Then I should see the account deleted message "ACCOUNT DELETED!"
    And I click on continue button after deleting account