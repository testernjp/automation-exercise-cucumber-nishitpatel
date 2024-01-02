package com.automationexercise.steps;

import com.automationexercise.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ExtraSteps {
    @When("I click on header menu option Contact us")
    public void iClickOnHeaderMenuOptionContactUs() {
        new ContactUsPage().clickOnContactUsButton();
    }

    @Then("I should see welcome text on contact us page GET IN TOUCH")
    public void iShouldSeeWelcomeTextOnContactUsPageGETINTOUCH() {
        new ContactUsPage().verifyGetInTouchText();
    }

    @And("I enter name {string} email {string} subject {string} message {string}")
    public void iEnterNameEmailSubjectSubject(String name, String email, String subject, String message) {
        new ContactUsPage().sendDataToNameField(name, email, subject, message);
    }

    @And("I upload file")
    public void iUploadFile() {
        new ContactUsPage().uploadFile();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        new ContactUsPage().clickOnSubmitButton();
    }

    @And("I click on ok button popup")
    public void iClickOnOkButtonPopup() {
        new ContactUsPage().acceptPopupMessage();
    }

    @Then("I should see the success message Success! Your details have been submitted successfully.")
    public void iShouldSeeTheSuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfully() {
    }

    @And("I click on home button")
    public void iClickOnHomeButton() {
        new ContactUsPage().clickOnHomeButton();
    }

    @Then("I am on homepage and verify the homepage URL")
    public void iAmOnHomepageAndVerifyTheHomepageURL() {
        Assert.assertEquals(new LoginPage().getCurrentURL(), "https://automationexercise.com/contact_us#google_vignette");
    }


    @When("I click on Test Cases button")
    public void iClickOnTestCasesButton() throws InterruptedException {
        new HomePage().clickOnTestCasesButton();
    }

    @Then("I am navigated to test cases page")
    public void iAmNavigatedToTestCasesPage() {
        Assert.assertEquals(new LoginPage().getCurrentURL(), "https://automationexercise.com/test_cases");
    }

    @When("I scroll down up to subscription link")
    public void iScrollDownUpToSubscriptionLink() {
        new HomePage().scrollDownToSubscriptionLink();
    }

    @Then("I enter email {string}")
    public void iEnterEmail(String email) {
        new HomePage().sendDataToSubscriptionEmail(email);
    }

    @And("I click on arrow button")
    public void iClickOnArrowButton() {
        new HomePage().clickOnArrowToSubscribe();
    }

    @And("I should see the success subscription message {string}")
    public void iShouldSeeTheSuccessSubscriptionMessage(String expectedMessage) {
        Assert.assertEquals(new HomePage().getSubscriptionSuccessMessage(), expectedMessage);
    }


    @When("I click on header menu option Cart")
    public void iClickOnHeaderMenuOptionCart() {
        new HomePage().clickOnCartButton();
    }

    @And("I should see the welcome text on shopping cart page {string}")
    public void iShouldSeeTheWelcomeTextOnShoppingCartPage(String welcomeText) {
        Assert.assertEquals(new ShoppingCartPage().getShoppingCartWelcomeText(), welcomeText);
    }

    @And("I click on Proceed to Checkout button")
    public void iClickOnProceedToCheckoutButton() {
        new ShoppingCartPage().clickOnProceedToCheckoutButton();
    }

    @And("I click on register link in the checkout popup")
    public void iClickOnRegisterLinkInTheCheckoutPopup() {
        new ShoppingCartPage().clickOnRegisterLoginLinkOnCheckoutPopup();
    }

    @And("I send name {string} and email {string} to signup")
    public void iSendNameAndEmailToSignup(String name, String email) {
        new ShoppingCartPage().sendDataToSignupFields(name, email);
    }

    @And("I click on button {string}")
    public void iClickOnButton(String lButton) {
        new LoginPage().clickOnLoginPageButton(lButton);
    }

    @And("I fill all details in signup page {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iFillAllDetailsInSignupPage(String title, String pass, String day, String month, String year, String fName, String lName, String add1, String add2, String country, String state, String city, String zipcode, String pNumber) {
        new RegisterPage().sendDataToSignupForm(title, pass, day, month, year, fName, lName, add1, add2, country, state, city, zipcode, pNumber);
    }

    @And("I click on Create Account button")
    public void iClickOnCreateAccountButton() {
        new RegisterPage().clickOnCreateAccountButton();
    }

    @Then("I see account created message {string}")
    public void iSeeAccountCreatedMessage(String expectedText) {
        Assert.assertEquals(new RegisterPage().getAccountCreatedMessage(), expectedText);
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        new RegisterPage().clickOnContinueButtonAfterAccountCreated();
    }

    @Then("I should see the text {string} {string}")
    public void iShouldSeeTheText(String text, String name) {
        Assert.assertEquals(new RegisterPage().getLoggedInAsUserNameText(), text + name);
    }

    @And("I click on header menu option {string}")
    public void iClickOnHeaderMenuOption(String option) {
        new HomePage().clickOnHeaderTab(option);
    }

    @And("I should see the text on checkout page {string}")
    public void iShouldSeeTheTextOnCheckoutPage(String expectedText) {
        Assert.assertEquals(new CheckoutPage().verifyTextOnCheckoutPage(expectedText), expectedText);
    }

    @And("I enter details into comment area {string}")
    public void iEnterDetailsIntoCommentArea(String comment) {
    }

    @And("I click on place order button")
    public void iClickOnPlaceOrderButton() {
        new CheckoutPage().clickOnPlaceOrderButton();
    }

    @And("I enter payment details {string} {string} {string} {string} and {string}")
    public void iEnterPaymentDetailsAnd(String name, String cNumber, String CVC, String month, String year) {
        new PaymentPage().sendPaymentDetails(name, cNumber, CVC, month, year);
    }

    @And("I click on Pay and Confirm Order button")
    public void iClickOnPayAndConfirmOrderButton() {
        new PaymentPage().clickOnPayAndConfirmOrderButton();
    }

    @Then("I should see the order confirmation message {string}")
    public void iShouldSeeTheOrderConfirmationMessage(String expectedMessage) {
        Assert.assertEquals(new PaymentPage().getOrderConfirmationMessage(), expectedMessage);
    }

    @Then("I should see the account deleted message {string}")
    public void iShouldSeeTheAccountDeletedMessage(String expectedText) {
        Assert.assertEquals(new RegisterPage().getAccountDeletedMessage(), expectedText);
    }

    @Then("I click on continue button after deleting account")
    public void iClickOnContinueButtonAfterDeletingAccount() {
        new RegisterPage().clickOnContinueButtonAfterAccountDeletedMessage();
    }


    @Then("I click on cross button to remove the product from the cart")
    public void iClickOnCrossButtonToRemoveTheProductFromTheCart() {
        new ShoppingCartPage().clickOnCrossButtonAcrossProductToRemove();
    }

    @And("I click on download invoice after order success")
    public void iClickOnDownloadInvoiceAfterOrderSuccess() {
        new PaymentPage().clickOnDownloadInvoiceButtonAfterOrderSuccessMessage();
    }

    @And("I click on continue button after order success")
    public void iClickOnContinueButtonAfterOrderSuccess() {
        new PaymentPage().clickOnContinueButtonAfterOrderSuccessMessage();
    }

    @Then("I should see the subscription {string} text")
    public void iShouldSeeTheSubscriptionText(String expectedText) {
        Assert.assertEquals(new HomePage().getSubscriptionText(), expectedText);
    }

    @And("I click on arrow up button at bottom right corner")
    public void iClickOnArrowUpButtonAtBottomRightCorner() {
        new HomePage().clickOnBottomRightArrowButton();
    }

    @And("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedText) {
        Assert.assertEquals(new HomePage().getFullFledgedText(), expectedText);
    }

    @And("I scroll up")
    public void iScrollUp() {
        new HomePage().scrollUp();
    }
}
