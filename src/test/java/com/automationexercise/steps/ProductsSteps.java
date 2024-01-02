package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductsSteps {
    @When("I click on products tab")
    public void iClickOnProductsTab() throws InterruptedException {
        new HomePage().clickOnProductsTab();
    }

    @Then("I should see text ALL PRODUCTS on product page")
    public void iShouldSeeTextALLPRODUCTSOnProductPage() {
        new ProductPage().getAllProductText();
    }

    @And("I click on view product of first product Blue Top")
    public void iClickOnViewProductOfFirstProductBlueTop() {
        new ProductPage().clickOnBlueTop();
    }

    @And("I should see product name Blue Top")
    public void iShouldSeeProductNameBlueTop() {
        new ProductDetailsPage().getBlueTopText();
    }

    @And("I should see category Category: Women > Tops")
    public void iShouldSeeCategoryCategoryWomenTops() {
        new ProductDetailsPage().getCategoryWomenTopsText();
    }

    @And("I should see price Rs. {int}")
    public void iShouldSeePriceRs(int price) {
    }

    @And("I should see availability Availability: In Stock")
    public void iShouldSeeAvailabilityAvailabilityInStock() {
    }

    @And("I should see condition Condition: New")
    public void iShouldSeeConditionConditionNew() {
    }

    @And("I should see brand Brand: Polo")
    public void iShouldSeeBrandBrandPolo() {
    }

    @Then("I should see text {string} on product page")
    public void iShouldSeeTextOnProductPage(String expectedText) throws InterruptedException {
        Assert.assertEquals(new ProductPage().getAllProductText(), expectedText);
    }

    @And("I enter product name {string} in search bar")
    public void iEnterProductNameInSearchBar(String productName) {
        new ProductPage().sendTextToSearchBar(productName);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        new ProductPage().clickOnSearchButton();
    }

    @Then("I should see the text {string} on the page")
    public void iShouldSeeTheTextOnThePage(String expectedText) {
        Assert.assertEquals(new ProductPage().getSearchedProductsText(), expectedText);

    }

    @And("I should see the searched product {string}")
    public void iShouldSeeTheSearchedProduct(String pName) {
        Assert.assertEquals(new ProductPage().getSearchedProductName(), pName);
    }

    @And("I enter product name Blue Top in search bar")
    public void iEnterProductNameMenTshirtInSearchBar() {

    }

    @Then("I should see the text SEARCHED PRODUCTS on the page")
    public void iShouldSeeTheTextSEARCHEDPRODUCTSOnThePage() {
    }

    @And("I should see the searched product Men Tshirt")
    public void iShouldSeeTheSearchedProductMenTshirt() {
    }

    @Then("I add product Men Tshirt to the cart")
    public void iAddProductMenTshirtToTheCart() {
    }

    @And("I click on continue shopping link")
    public void iClickOnContinueShoppingLink() {
        new ProductPage().clickOnContinueShoppingLink();
    }

    @And("I add product {string} to the cart")
    public void iAddProductToTheCart(String product) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(product);
    }

    @And("I click on view cart in popup")
    public void iClickOnViewCartInPopup() {
        new ProductPage().clickOnViewCartLink();
    }

    @Then("I verify the product Blue Top in shopping cart")
    public void iVerifyTheProductBlueTopInShoppingCart() {
        new ProductPage().getBlueTopProductsText();
    }

    @Then("I verify the product Men Tshirt in shopping cart")
    public void iVerifyTheProductMenTshirtInShoppingCart() {
        new ProductPage().getMenTshirtProductsText();
    }

    @When("I click on view product of first product {string}")
    public void iClickOnViewProductOfFirstProduct(String firstProduct) {
        new ProductDetailsPage().clickOnFirstProduct();
    }

    @And("I increase the quantity {string}")
    public void iIncreaseTheQuantity(String quantityUnit) {
        new ProductDetailsPage().sendQuantity(quantityUnit);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new ProductDetailsPage().clickOnAddToCartButton();
    }

    @And("I click on view cart link in success message")
    public void iClickOnViewCartLinkInSuccessMessage() {
        new ProductDetailsPage().clickOnViewCartLinkInSuccessMessage();
    }

    @Then("I should see quantity {string}")
    public void iShouldSeeQuantity(String quantityTotal) {
        Assert.assertEquals(new ShoppingCartPage().getQuantity(), quantityTotal);
    }


    @Then("I click on {string} category")
    public void iClickOnCategory(String category) throws InterruptedException {
        new ProductPage().clickOnWomenCategoryTab();

    }

    @And("I click on {string} in women category")
    public void iClickOnInWomenCategory(String subCategory) throws InterruptedException {
        new ProductPage().clickOnSubCategoryOfWomen(subCategory);
    }

    @And("I should see {string} page title")
    public void iShouldSeePageTitle(String expectedTitle) {
        Assert.assertEquals(new ProductPage().getSubMenuPageTitle(), expectedTitle);
    }

    @And("I click on {string} in men category")
    public void iClickOnInMenCategory(String subCategory) {
        new ProductPage().clickOnSubCategoryOfMen(subCategory);
    }

    @Then("I click on {string} brand in Brands tab")
    public void iClickOnBrandInBrandsTab(String brand) {
        new ProductPage().clickOnBrandOnBrandsTab(brand);
    }

    @Then("I verify the product {string} in shopping cart")
    public void iVerifyTheProductInShoppingCart(String pName) {
        Assert.assertEquals(new ShoppingCartPage().getProductNameFromCart(pName), pName);
    }


    @And("I enter {string} name at your name field")
    public void iEnterNameAtYourNameField(String name) {
        new ProductDetailsPage().sendNameToYourNameField(name);
    }

    @And("I enter {string} email at email address field")
    public void iEnterEmailAtEmailAddressField(String email) {
        new ProductDetailsPage().sendEmailToEmailAddressField(email);
    }

    @And("I enter {string} message to review here field")
    public void iEnterMessageToReviewHereField(String review) {
        new ProductDetailsPage().sendReviewToAddReviewField(review);
    }

    @And("I click on review submit button")
    public void iClickOnReviewSubmitButton() {
        new ProductDetailsPage().clickOnReviewSubmitButton();
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(new ProductDetailsPage().getThankYouForReviewMessage(), message);
    }

    @When("I scroll down up to recommended items text")
    public void iScrollDownUpToRecommendedItemsText() {
        new HomePage().scrollDownToRecommendedItems();
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String expectedText) {
        Assert.assertEquals(new HomePage().getRecommendedItemText(), expectedText);
    }

    @And("I add to cart {string} product from recommended items")
    public void iAddToCartProductFromRecommendedItems(String pName) {
        new HomePage().clickAddToCartOnRecommendedItems(pName);
    }
}
