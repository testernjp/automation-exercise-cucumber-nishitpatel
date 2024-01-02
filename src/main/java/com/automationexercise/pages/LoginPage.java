package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement loginPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButtonOnLogin;

    @CacheLookup
    @FindBy (xpath = "//p[normalize-space()='Your email or password is incorrect!'")
    WebElement emailAlreadyExistErrorMessage;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButtonOnLogin;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Signup']")
    WebElement signupButton;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupText;

    @CacheLookup
    @FindBy (xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement incorrectLoginCredentialMessage;

    public String getTextFromLoginPage(String text){
        if(text.equalsIgnoreCase("Login to your account")){
            log.info("Getting text as Login to your account : " + loginText.toString());
            return getTextFromElement(loginText);
        } else if (text.equalsIgnoreCase("New User Signup!")) {
            log.info("Getting text as New User Signup! : " + newUserSignupText.toString());
            return getTextFromElement(newUserSignupText);
        } else if (text.equalsIgnoreCase("Your email or password is incorrect!")) {
            log.info("Getting text for invalid credentials while login : " + incorrectLoginCredentialMessage.toString());
            return getTextFromElement(incorrectLoginCredentialMessage);
        } else {
            return "Text is not correct";
        }
    }

    public void clickOnLoginPageButton(String button){
        if (Objects.equals(button, "Login")){
            clickOnElement(loginButton);
            log.info("Clicking on Login button : " + loginButton.toString());
        } else if (Objects.equals(button, "Signup")) {
            clickOnElement(signupButton);
            log.info("Clicking on Signup button : " + signupButton.toString());
        } else {
            System.out.println("No button clicked");
        }
    }

    public void sendDataToLoginFields(String email, String password){
        sendTextToElement(loginEmail, email);
        log.info("Sending data to Email Address Field in Login : " + loginEmail.toString());
        sendTextToElement(loginPassword, password);
        log.info("Sending data to Password Field in Login : " + loginPassword.toString());
    }


    public void verifyLoginText() {
        log.info("Login to your account message" + loginText.toString());
        getTextFromElement(loginText);
    }

    public void enterLoginEmail(String loginEmailAdd) {
        log.info("Enter email" + loginEmail.toString());
        sendTextToElement(loginEmail, loginEmailAdd);
    }

    public void enterLoginPassword(String loginPasswordAdd) {
        log.info("Enter password" + loginPassword.toString());
        sendTextToElement(loginPassword, loginPasswordAdd);
    }

    public void iClickOnLoginButtonOnLoginPage() {
        log.info("Click on Login Button" + loginButtonOnLogin.toString());
        clickOnElement(loginButtonOnLogin);
    }

    public String getEmailAlreadyExistErrorMessage() {
        log.info("Email already exists" + emailAlreadyExistErrorMessage.toString());
        return getTextFromElement(emailAlreadyExistErrorMessage);
    }

    public void iClickOnLogoutButtonOnLoginPage() {
        log.info("Click on Logout Button" + logoutButtonOnLogin.toString());
        clickOnElement(logoutButtonOnLogin);
    }

    public String getCurrentURL(){
        log.info("Getting Login Page URL ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }


}
