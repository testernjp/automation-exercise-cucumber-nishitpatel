package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupText;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement enterName;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement signUpButton;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement accountText;


    @CacheLookup
    @FindBy(id = "id_gender1")
    WebElement mrRadioButton;

    @CacheLookup
    @FindBy(id = "id_gender2")
    WebElement mrsRadioButton;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "days")
    WebElement dayDropdown;

    @CacheLookup
    @FindBy(id = "months")
    WebElement monthDropdown;

    @CacheLookup
    @FindBy(id = "years")
    WebElement yearDropdown;

    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement newsLetterCheckBox;

    @CacheLookup
    @FindBy(id = "optin")
    WebElement specialOffersCheckBox;

    @CacheLookup
    @FindBy(id = "first_name")
    WebElement firstNameInAddressForm;

    @CacheLookup
    @FindBy(id = "last_name")
    WebElement lastNameInAddressForm;

    @CacheLookup
    @FindBy(id = "company")
    WebElement companyNameInAddressForm;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement addressOneField;

    @CacheLookup
    @FindBy(id = "address2")
    WebElement addressTwoField;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryDropdown;

    @CacheLookup
    @FindBy(id = "state")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement zipcodeField;

    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement mobileNumberField;

    @CacheLookup
    @FindBy(xpath = "(//button[@type = 'submit'])[1]")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//li[10]//a[1]")
    WebElement loggedInUsername;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccount;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement deleteAccountMessage;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueButtonDelete;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement emailAlreadyExistsMessageError;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterAccountCreated;

    @CacheLookup
    @FindBy (xpath = "//li[10]//a[1]")
    WebElement loggedInAsTab;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterAccountDeletedMessage;

    @CacheLookup
    @FindBy (xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedMessage;




    public String verifySignUpTextIsVisible() {
        log.info("Verify Signup Text " + newUserSignupText.toString());
        return getTextFromElement(newUserSignupText);

    }


    public void enterNameAndEmailAddress(String name, String mail) {
        log.info("Enter name and email address" + enterName.toString() + enterEmail.toString());
        sendTextToElement(enterName, name);
        sendTextToElement(enterEmail, mail + getRandomString(2) + "@gmail.com");
    }

    public void clickOnSignUpButton() {
        log.info("Signup Button" + signUpButton.toString());
        clickOnElement(signUpButton);

    }

    public void verifyAccountText() {
        log.info("Account text" + accountText.toString());
        getTextFromElement(accountText);

    }

    public void fillDataInSignUpForm(String title, String password, String day, String month, String year) {

        if (title.equalsIgnoreCase("Mr")) {
            clickOnElement(mrRadioButton);
            log.info("Selecting Mr radio button" + mrRadioButton.toString());
        } else {
            clickOnElement(mrsRadioButton);
            log.info("Selecting Mrs radio button" + mrsRadioButton.toString());
        }
        sendTextToElement(passwordField, password);
        log.info("Enter password" + passwordField.toString());
        selectByVisibleTextFromDropDown(dayDropdown, day);
        log.info("select day" + dayDropdown.toString());
        selectByVisibleTextFromDropDown(monthDropdown, month);
        log.info("select month" + monthDropdown.toString());
        selectByVisibleTextFromDropDown(yearDropdown, year);
        log.info("select year" + yearDropdown.toString());
    }

    public void sendDataToSignupForm(String title, String password, String day, String month, String year, String fName,
                                     String lName, String add1, String add2, String country, String state, String city,
                                     String zipcode, String mNumber) {
        if (title.equalsIgnoreCase("Mr")){
            clickOnElement(mrRadioButton);
            log.info("Selecting radio button against Mr.");
        } else {
            clickOnElement(mrsRadioButton);
            log.info("Selecting radio button against Mrs.");
        }
        sendTextToElement(passwordField, password);
        log.info("Sending " + password + " to password field");
        selectByVisibleTextFromDropDown(dayDropdown, day);
        log.info("Selecting " + day + " from Day dropdown in DOB");
        selectByVisibleTextFromDropDown(monthDropdown, month);
        log.info("Selecting " + month + " from Month dropdown in DOB");
        selectByVisibleTextFromDropDown(yearDropdown, year);
        log.info("Selecting " + year + " from Year dropdown in DOB");
        sendTextToElement(firstNameInAddressForm, fName);
        log.info("Sending " + fName + " to First Name field");
        sendTextToElement(lastNameInAddressForm, lName);
        log.info("Sending " + lName + " to Last Name field");
        sendTextToElement(addressOneField, add1);
        log.info("Sending " + add1 + " to Address1 field");
        sendTextToElement(addressTwoField, add2);
        log.info("Sending " + add2 + " to Address2 field");
        selectByVisibleTextFromDropDown(countryDropdown, country);
        log.info("Selecting " + country + " from Country dropdown");
        sendTextToElement(stateField, state);
        log.info("Sending " + state + " to State field");
        sendTextToElement(cityField, city);
        log.info("Sending " + city + " to City field");
        sendTextToElement(zipcodeField, zipcode);
        log.info("Sending " + zipcode + " to Zipcode field");
        sendTextToElement(mobileNumberField, mNumber);
        log.info("Sending " + mNumber + " to Mobile Number field");
    }

    public void clickOnSignUpNewsLetterCheckBox() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(newsLetterCheckBox);
        log.info("Click on News Letter Subscription Check Box : " + newsLetterCheckBox.toString());
    }

    public void clickOnReceiveSpecialOffersCheckBox() {
        clickOnElement(specialOffersCheckBox);
        log.info("Click Receive Special Offer Check Box : " + specialOffersCheckBox.toString());
    }

    public void enterFirstNameInAddressInfo(String firstName) {
        sendTextToElement(firstNameInAddressForm, firstName);
        log.info("enter first name " + firstNameInAddressForm.toString());
    }

    public void enterLastNameInAddressInfo(String lastName) {
        sendTextToElement(lastNameInAddressForm, lastName);
        log.info("enter first name " + lastNameInAddressForm.toString());

    }

    public void enterCompanyNameInAddressInfo(String company) {
        sendTextToElement(companyNameInAddressForm, company);
        log.info("Enter company name : " + companyNameInAddressForm.toString());
    }

    public void enterAddressLineOne(String addressOne) {
        sendTextToElement(addressOneField, addressOne);
        log.info("Enter address field " + addressOneField.toString());
    }

    public void enterAddressLineTwo(String addressTwo) {
        sendTextToElement(addressTwoField, addressTwo);
        log.info("Enter address field " + addressTwoField.toString());
    }

    public void selectCountryFromDropdown(String country) {
        selectByVisibleTextFromDropDown(countryDropdown, country);
        log.info("Select country " + countryDropdown.toString());
    }

    public void enterStateInAddressForm(String state) {
        sendTextToElement(stateField, state);
        log.info("Enter state " + stateField.toString());
    }

    public void enterCityInAddressForm(String city) {
        sendTextToElement(cityField, city);
        log.info("Enter city " + cityField.toString());
    }

    public void enterZipcodeInAddressInfo(String zipcode) {
        sendTextToElement(zipcodeField, zipcode);
        log.info("Enter zipcode " + zipcodeField.toString());

    }

    public void enterMobileNumberInAddressInfo(String mobNumber) {
        sendTextToElement(mobileNumberField, mobNumber);
        log.info("Enter mobile" + mobileNumberField.toString());

    }

    public void clickOnCreateAccountButton() {
        try {
            createAccountButton.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[@type = 'submit'])[1]")));
        }
        log.info("Click On create account button" + createAccountButton.toString());
    }

    public void getAccountCreatedText() {
        getTextFromElement(accountCreatedMessage);
        log.info("Getting account created text " + accountCreatedMessage.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on continue button" + continueButton.toString());
    }

    public void getLoggedInAsUsernameText() {
        getTextFromElement(loggedInUsername);
        log.info("Logged In as" + loggedInUsername.toString());

    }

    public void clickOnDeleteAccount() {
        clickOnElement(deleteAccount);
        log.info("Delete account" + deleteAccount.toString());
    }

    public void getDeleteAccountText() {
        getTextFromElement(deleteAccountMessage);
        log.info("Delete account Message" + deleteAccountMessage.toString());
    }

    public void clickOnContinueAfterDelete() {
        clickOnElement(continueButtonDelete);
        log.info("Click on continue" + continueButtonDelete.toString());
    }

    public String getEmailAlreadyExistErrorMessage() {
        log.info("Email already exists" + emailAlreadyExistsMessageError.toString());
        return getTextFromElement(emailAlreadyExistsMessageError);
    }
    public void enterNameAndEmailAddressOnLogin(String name, String mail) {
        log.info("Enter name and email address" + enterName.toString() + enterEmail.toString());
        sendTextToElement(enterName, name);
        sendTextToElement(enterEmail, mail);
    }

    public String getAccountCreatedMessage() {
        log.info("Getting account created message : " + accountCreatedMessage.toString());
        return getTextFromElement(accountCreatedMessage);
    }

    public void clickOnContinueButtonAfterAccountCreated() {
        log.info("Clicking on continue button after account created : " + continueButtonAfterAccountCreated.toString());
        clickOnElement(continueButtonAfterAccountCreated);
    }

    public String getLoggedInAsUserNameText(){
        log.info("Getting text from login page : " + loggedInAsTab.toString());
        return getTextFromElement(loggedInAsTab);
    }

    public String getAccountDeletedMessage(){
        log.info("Getting account deleted text : " + accountDeletedMessage.toString());
        return getTextFromElement(accountDeletedMessage);
    }

    public void clickOnContinueButtonAfterAccountDeletedMessage() {
        clickOnElement(continueButtonAfterAccountDeletedMessage);
        log.info("Clicking on continue button after deleting account : " + continueButtonAfterAccountDeletedMessage.toString());
    }


}
