package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Utility {

    private static final Logger log = LogManager.getLogger(ContactUsPage.class.getName());


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getInTouchText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement contactUsLink;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement subjectField;

    @CacheLookup
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFile;

    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement detailsSubmittedSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Home']")
    WebElement homeButton;

    public void clickOnContactUsButton() {
        log.info("Click on Contact Us" + contactUsLink.toString());
        clickOnElement(contactUsLink);
    }


    public String verifyGetInTouchText() {
        log.info("Getting text from welcome page : " + getInTouchText.toString());
        return getTextFromElement(getInTouchText);
    }

    public void sendDataToNameField(String name, String email, String subject, String message) {
        log.info("Sending " + name + " to name field : " + nameField.toString());
        sendTextToElement(nameField, name);
        log.info("Sending " + email + " to email field : " + emailField.toString());
        sendTextToElement(emailField, email);
        log.info("Sending " + subject + " to subject field : " + subjectField.toString());
        sendTextToElement(subjectField, subject);
        log.info("Sending " + message + " to message field : " + messageField.toString());
        sendTextToElement(messageField, message);
    }


    public void clickOnSubmitButton() {
        try {
            submitButton.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='submit']")));
        }
        log.info("Clicking on submit button : " + submitButton.toString());
    }

    public void uploadFile() {
        log.info("Uploading file : " + uploadFile.toString());
        uploadFile.sendKeys("C:/Soft/text.txt");
    }

    public void acceptPopupMessage() {
        log.info("Accepting the alert : ");
        acceptAlert();
    }

    public String getDetailsSubmittedMessage() {
        log.info("Getting detailed success message : " + detailsSubmittedSuccessMessage.toString());
        return getTextFromElement(detailsSubmittedSuccessMessage);
    }

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
        log.info("Clicking on home button : " + homeButton.toString());
    }
}
