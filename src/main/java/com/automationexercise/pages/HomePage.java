package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupAndLoginButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCasesLink;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsTab;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement subscriptionArrowButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement cartMenuLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    List<WebElement> headerTabs;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'recommended-item-carousel']//div[@class = 'productinfo text-center']/p")
    List<WebElement> recommendedItemsProductsList;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-angle-up']")
    WebElement bottomRightArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;


    public void clickOnSignupAndLoginButton(String s) {
        log.info("Click on Signup/Login Button" + signupAndLoginButton.toString());
        clickOnElement(signupAndLoginButton);

    }


    public void clickOnTestCasesButton() throws InterruptedException {
        log.info("Click on Test Cases Button" + testCasesLink.toString());
        clickOnElement(testCasesLink);
        Thread.sleep(3000);

    }

    public void clickOnProductsTab() throws InterruptedException {
        clickOnElement(productsTab);
        Thread.sleep(2000);
        log.info("Clicking on products tab : " + productsTab.toString());
    }

    public void scrollDownToSubscriptionLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", subscriptionText);
        log.info("Scroll Down to Subscription");
    }

    public void sendDataToSubscriptionEmail(String email) {
        log.info("Enter email for subscription : " + subscriptionEmail.toString());
        sendTextToElement(subscriptionEmail, email);
    }

    public void clickOnArrowToSubscribe() {
        clickOnElement(subscriptionArrowButton);
        log.info("Clicking on subscription arrow button : " + subscriptionArrowButton.toString());
    }

    public String getSubscriptionSuccessMessage() {
        log.info("Getting subscription success message : " + subscriptionSuccessMessage.toString());
        return getTextFromElement(subscriptionSuccessMessage);
    }

    public void clickOnCartButton() {
        log.info("Click on Cart Button" + testCasesLink.toString());
        clickOnElement(cartMenuLink);
    }

    public void clickOnHeaderTab(String option) {
        for (WebElement op : headerTabs) {
            //System.out.println(op.getText());
            if (op.getText().equalsIgnoreCase(option)) {
                op.click();
                log.info("CLicking on " + option + " header tab : " + headerTabs.toString());
                break;
            }
        }
    }

    public void scrollDownToRecommendedItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsText);
        log.info("Scroll Down to recommended items");
    }

    public String getRecommendedItemText() {
        log.info("Getting recommended items text : " + recommendedItemsText.toString());
        return getTextFromElement(recommendedItemsText);
    }

    public void clickAddToCartOnRecommendedItems(String pName) {
        for (WebElement pr : recommendedItemsProductsList) {
            if (pr.getText().equalsIgnoreCase(pName)) {
                driver.findElement(with(By.xpath("//a[@class='btn btn-default add-to-cart']")).below(pr)).click();
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public String getSubscriptionText() {
        log.info("Getting Subscription text : " + subscriptionText.toString());
        return getTextFromElement(subscriptionText);
    }

    public void clickOnBottomRightArrowButton() {
        log.info("Clicking on bottom right corner arrow button : " + bottomRightArrowButton.toString());
        clickOnElement(bottomRightArrowButton);
    }

    public String getFullFledgedText() {
        log.info("Getting full fledged text from top of the page : " + fullFledgedText.toString());
        return getTextFromElement(fullFledgedText);
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
        log.info("Scroll up to (0,0)");
    }
}
