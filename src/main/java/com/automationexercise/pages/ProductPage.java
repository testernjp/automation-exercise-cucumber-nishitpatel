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

public class ProductPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement allProductText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'productinfo text-center']/p")
    List<WebElement> productName;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-justified']/li/a")
    WebElement viewProductTab;

    @CacheLookup
    @FindBy(id = "search_product")
    WebElement searchBar;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement searchedProductsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'single-products']/div/p")
    WebElement searchedProductName;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement womenTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-collapse in']//a[contains(text(),'Dress')]")
    List<WebElement> womenSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Men']")
    WebElement menTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'Men']/div/ul/li/a")
    List<WebElement> menSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Kids']")
    WebElement kidsTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//h2[@class = 'title text-center']")
    WebElement subMenuPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-stacked']/li/a")
    List<WebElement> brandsList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']//div//p")
    WebElement blueTop;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    WebElement addToProductButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Men Tshirt']")
    WebElement blueTopCheckoutText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Blue Top']")
    WebElement menTshirtCheckOutText;


    public String getAllProductText() {
        log.info("Verify All Products : " + allProductText.toString());
        return getTextFromElement(allProductText);
    }

    public void clickOnBlueTop() {
        log.info("Clicking on blue top : " + viewProductTab.toString());
        clickOnElement(viewProductTab);
    }

    public void sendTextToSearchBar(String pName) {
        sendTextToElement(searchBar, pName);
        log.info("Sending " + pName + " to search bar : " + searchBar.toString());
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
        log.info("Clicking on the search button : " + searchButton.toString());
    }

    public String getSearchedProductsText() {
        log.info("Getting Searched Products text : " + searchedProductsText.toString());
        return getTextFromElement(searchedProductsText);
    }

    public String getSearchedProductName() {
        log.info("Getting Searched Product name : " + searchedProductName.toString());
        return getTextFromElement(searchedProductName);
    }

    //    public void clickOnBlueTopProduct() {
//        log.info("Click on blue top " + blueTop.toString());
//        mouseHoverToElement(blueTop);
//        WebElement getADemo = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='product-image-wrapper']//div//a")).below(blueTop));
//        getADemo.click();
//}
    public void mouseHoverAndClickAddToCartOnProduct(String pName) {
        for (WebElement pr : productList) {
            if (pr.getText().equalsIgnoreCase(pName)) {
                mouseHoverToElement(pr);
                log.info("Hovering mouse over " + pName + " : " + productList.toString());
                try {
                    addToProductButton.click();
                } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")));
                }
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public void clickOnContinueShoppingLink() {
        clickOnElement(continueShoppingLink);
        log.info("Clicking on continuer shopping link : " + continueShoppingLink.toString());
    }

    public void clickOnViewCartLink() {
        clickOnElement(viewCartLink);
        log.info("Clicking on view cart link after adding product to the cart : " + viewCartLink.toString());
    }

    public String getBlueTopProductsText() {
        log.info("Getting Searched Products text : " + blueTopCheckoutText.toString());
        return getTextFromElement(blueTopCheckoutText);
    }

    public String getMenTshirtProductsText() {
        log.info("Getting Searched Products text : " + menTshirtCheckOutText.toString());
        return getTextFromElement(menTshirtCheckOutText);
    }
    public void clickOnCategory(String category){
        if (category.equalsIgnoreCase("Men")){
            clickOnElement(menTabInCategory);
            log.info("Clicking on Men category : " + menTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Women")) {
            clickOnElement(womenTabInCategory);
            log.info("Clicking on Women category : " + womenTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Child")) {
            clickOnElement(kidsTabInCategory);
            log.info("Clicking on Kids category : " + kidsTabInCategory.toString());
        } else {
            System.out.println("Category is not available");
        }
    }

    public void clickOnWomenCategoryTab() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(womenTabInCategory);
        log.info("Clicking on Women category : " + womenTabInCategory.toString());
    }
    public void clickOnSubCategoryOfWomen(String womenSubCategory)  {
        for (WebElement s : womenSubMenuList) {
            if(s.getText().equalsIgnoreCase(womenSubCategory)){
                clickOnElement(s);
                log.info("Clicking on " + womenSubCategory + " of women sub category : " + womenSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public String getSubMenuPageTitle() {
        log.info("Getting Sub Menu Page Title : " + subMenuPageTitle.toString());
        return getTextFromElement(subMenuPageTitle);
    }

    public void clickOnSubCategoryOfMen(String menSubCategory) {
        for (WebElement s : menSubMenuList) {
            if(s.getText().equalsIgnoreCase(menSubCategory)){
                clickOnElement(s);
                log.info("Clicking on " + menSubCategory + " of men sub category : " + menSubMenuList.toString());
                break;
            }else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public void clickOnBrandOnBrandsTab(String brand){
        for (WebElement b : brandsList) {
            System.out.println(b);
            if (b.getText().equalsIgnoreCase(brand)){
                b.click();
                log.info("Clicking on " + brand + " in Brands tab : " + brandsList.toString());
                break;
            } else {
                System.out.println("Brand name is not available");
            }
        }
    }


}
