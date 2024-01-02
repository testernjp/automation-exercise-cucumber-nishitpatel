package com.automationexercise.steps;

import com.automationexercise.pages.CheckoutPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.RegisterPage;
import com.automationexercise.propertyreader.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I click on {string} button")
    public void iClickOnSignupLoginButton(String login) {
        new HomePage().clickOnSignupAndLoginButton("Signup/Login");
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        new RegisterPage().verifySignUpTextIsVisible();
    }

    @And("I enter {string} in the name and enter {string} in the email address")
    public void iEnterInTheNameAndEnterInTheEmailAddress(String name, String email) {
        new RegisterPage().enterNameAndEmailAddress(name, email);
    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() {
        new RegisterPage().clickOnSignUpButton();
    }

    @And("Verify the text ENTER ACCOUNT INFORMATION is visible")
    public void verifyTheTextENTERACCOUNTINFORMATIONIsVisible() {
        new RegisterPage().verifyAccountText();
    }

    @And("I select radiobutton Title {string} and I enter Name {string} and I enter Email {string} and I enter Password {string} and I enter Date of Birth as Day {string} Month {string} Year {string}")
    public void iSelectRadiobuttonTitleAndIEnterNameAndIEnterEmailAndIEnterPasswordAndIEnterDateOfBirthAsDayMonthYear(String title, String name, String email, String password, String day, String month, String year) {
        new RegisterPage().fillDataInSignUpForm(title, password, day, month, year);
    }

    @And("I select the checkbox for Sign up for our newsletter!")
    public void iSelectTheCheckboxForSignUpForOurNewsletter() throws InterruptedException {
        new RegisterPage().clickOnSignUpNewsLetterCheckBox();
    }

    @And("I select the checkbox for Receive special offers from our partners!")
    public void iSelectTheCheckboxForReceiveSpecialOffersFromOurPartners() {
        new RegisterPage().clickOnReceiveSpecialOffersCheckBox();
    }

    @And("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        new RegisterPage().enterFirstNameInAddressInfo(firstName);
    }

    @And("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        new RegisterPage().enterLastNameInAddressInfo(lastName);
    }

    @And("I enter company {string}")
    public void iEnterCompany(String company) {
        new RegisterPage().enterCompanyNameInAddressInfo(company);
    }

    @And("I enter Address {string}")
    public void iEnterAddress(String address) {
        new RegisterPage().enterAddressLineOne(address);
    }

    @And("I enter Addresstwo {string}")
    public void iEnterAddresstwo(String addressTwo) {
        new RegisterPage().enterAddressLineTwo(addressTwo);
    }

    @And("I enter country {string}")
    public void iEnterCountry(String country) {
        new RegisterPage().selectCountryFromDropdown(country);
    }

    @And("I enter state {string}")
    public void iEnterState(String state) {
        new RegisterPage().enterStateInAddressForm(state);
    }

    @And("I enter City {string}")
    public void iEnterCity(String city) {
        new RegisterPage().enterCityInAddressForm(city);
    }

    @And("zipcode {string}")
    public void zipcode(String zipcode) {
        new RegisterPage().enterZipcodeInAddressInfo(zipcode);
    }

    @And("mobile number {string}")
    public void mobileNumber(String mobile) {
        new RegisterPage().enterMobileNumberInAddressInfo(mobile);
    }

    @And("I click Create Account button")
    public void iClickCreateAccountButton() {
        new RegisterPage().clickOnCreateAccountButton();
    }

    @Then("I verify that ACCOUNT CREATED! is visible")
    public void iVerifyThatACCOUNTCREATEDIsVisible() {
        new RegisterPage().getAccountCreatedText();
    }


    @And("I click Continue button")
    public void iClickContinueButton() {
        new RegisterPage().clickOnContinueButton();
    }


    @Then("I verify that Logged in as username is visible")
    public void iVerifyThatLoggedInAsUsernameIsVisible() {
        new RegisterPage().getLoggedInAsUsernameText();
    }

    @And("I click Delete Account button")
    public void iClickDeleteAccountButton() {
        new RegisterPage().clickOnDeleteAccount();
    }

    @Then("I verify that text ACCOUNT DELETED! is visible and click Continue button")
    public void iVerifyThatTextACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        new RegisterPage().getDeleteAccountText();
        new RegisterPage().clickOnContinueAfterDelete();
    }


    @Then("I should see error message Email Address already exist!")
    public void iShouldSeeErrorMessageEmailAddressAlreadyExist() {new RegisterPage().getEmailAlreadyExistErrorMessage();
    }


    @And("I enter {string} in the name and  I enter {string} in the email address")
    public void iEnterInTheNameAndIEnterInTheEmailAddress(String name, String email) { new RegisterPage().enterNameAndEmailAddressOnLogin(name,email);
    }

    @Then("I should see the login page text {string}")
    public void iShouldSeeTheLoginPageText(String text) {
        Assert.assertEquals(new LoginPage().getTextFromLoginPage(text), text);
    }

    @And("I enter {string} email and {string} password for login")
    public void iEnterEmailAndPasswordForLogin(String email, String password) {
        new LoginPage().sendDataToLoginFields(email, password);
    }

    @Then("I should see the text {string}")
    public void iShouldSeeTheText(String text) {
        Assert.assertEquals(new RegisterPage().getLoggedInAsUserNameText(), text + PropertyReader.getInstance().getProperty("userName"));
    }

    @Then("I should see the delivery address is same address filled at the time registration of account {string}")
    public void iShouldSeeTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String expectedAddress) {
        Assert.assertEquals(new CheckoutPage().getDeliveryAddress(), expectedAddress);
    }

    @And("I should see billing address is same address filled at the time registration of account {string}")
    public void iShouldSeeBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String expectedAddress) {
        Assert.assertEquals(new CheckoutPage().getBillingAddress(), expectedAddress);
    }
}
