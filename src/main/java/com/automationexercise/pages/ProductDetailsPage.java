package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductDetailsPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-details']/div[2]/div/h2")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[1]")
    WebElement productCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/span/span")
    WebElement productPrice;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[2]")
    WebElement productAvailability;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[3]")
    WebElement productCondition;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[4]")
    WebElement productBrand;

    @CacheLookup
    @FindBy(xpath = "//input[@id='quantity']")
    WebElement productQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLinkInSuccessMessage;

    @CacheLookup
    @FindBy(id = "name")
    WebElement yourNameField;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "review")
    WebElement addReviewField;

    @CacheLookup
    @FindBy(id = "button-review")
    WebElement reviewSubmitButton;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Thank you for your review.']")
    WebElement thankYouForReviewMessage;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement categoryWomenTopsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement firstProductOnHome;


    public String verifyTheURL() {
        waitUntilVisibilityOfElementLocated(By.xpath("//a[normalize-space()='Write Your Review']"), 5);
        log.info("Getting Product Details Page URL : ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String getBlueTopText() {
        log.info("Verify blue top : " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getCategoryWomenTopsText() {
        log.info("Category: Women > Tops " + categoryWomenTopsText.toString());
        return getTextFromElement(categoryWomenTopsText);
    }

    public void sendQuantity(String qua) {
        log.info("Increasing the quantity : " + productQuantity.toString());
        productQuantity.clear();
        sendTextToElement(productQuantity, qua);
    }

    public void clickOnAddToCartButton() {
        log.info("Clicking on add to cart button : " + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public void clickOnViewCartLinkInSuccessMessage() {
        log.info("Clicking on the view cart link in success message : " + viewCartLinkInSuccessMessage.toString());
        clickOnElement(viewCartLinkInSuccessMessage);
    }

    public void clickOnFirstProduct() {
        log.info("Clicking first product : " + firstProductOnHome.toString());
        clickOnElement(firstProductOnHome);
    }
    public void sendNameToYourNameField(String name) {
        sendTextToElement(yourNameField, name);
        log.info("Sending " + name + " to your name field : " + yourNameField.toString());
    }
    public void sendEmailToEmailAddressField(String email) {
        sendTextToElement(emailAddressField, email);
        log.info("Sending " + email + " to email field : " + emailAddressField.toString());
    }

    public void sendReviewToAddReviewField(String review) {
        sendTextToElement(addReviewField, review);
        log.info("Sending " + review + " to add review field : " + addReviewField.toString());
    }

    public void clickOnReviewSubmitButton() {
        clickOnElement(reviewSubmitButton);
        log.info("Clicking on the review submit button : " + reviewSubmitButton.toString());
    }

    public String getThankYouForReviewMessage() {
        log.info("Getting thank you for review message test : " + thankYouForReviewMessage.toString());
        return getTextFromElement(thankYouForReviewMessage);
    }


}





