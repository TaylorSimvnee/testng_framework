package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EtsySearchPage;


public class _03_EtsyTest extends Base {
    /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy logo is displayed

    testEtsyLogo
     */


    @Test(priority = 1)
    public void testEtsyLogo() {
        driver.get("https://www.etsy.com/");

//        WebElement logo = driver.findElement(By.id("logo"));

        Assert.assertTrue(etsySearchPage.logo.isDisplayed());
    }

    /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy search input box and search button is displayed

    testEtsySearch
     */

    @Test(priority = 2)
    public void testEtsySearch() {
        driver.get("https://www.etsy.com/");
//        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
//        WebElement searchButton = driver.findElement(By.cssSelector("button[data-id='gnav-search-submit-button']"));

        Assert.assertTrue(etsySearchPage.searchInputBox.isDisplayed());
        Assert.assertTrue(etsySearchPage.searchButton.isDisplayed());
    }

    /*
    1. Go to https://www.etsy.com/
    2. Search for "canvas painting"
    3. Validate the results are more than zero
     */
    @Test(priority = 2, dependsOnMethods = "testEtsySearch")
    public void testEtsySearchResult() {
        driver.get("https://www.etsy.com/");

//        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));

        etsySearchPage.searchInputBox.sendKeys("canvas painting" + Keys.ENTER);

//        WebElement resultTag = driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span"));

        Assert.assertTrue(Integer.parseInt(etsySearchPage.resultTag.getText().replaceAll("[^0-9]", "")) > 0);
        // Assert.assertTrue(Integer.parseInt(resultTag.getText().substring(0, resultTag.getText().indexOf(" ")).replace(",", "")) > 0);
    }
    /*
    TC905: Validate Google Search results for “MacBook Pro”
    Given user navigates to “https://www.etsy.com/”
    Then user should see below menu item links with expected texts
    Father’s Day Gifts
    Jewelry & Accessories
    Clothing & Shoes
    Home & Living
    Wedding & Party
    Toys & Entertainment
    Art & Collectibles
    Craft Supplies
    Gifts & Gift Cards
     */

    @Test(priority = 4 , description = "Validate Etsy main header")
    public void testMainHeader(){
        driver.get("https://www.etsy.com/");

        String[] expectedTexts = {
                "Father's Day Gifts",
                "Jewelry & Accessories",
                "Clothing & Shoes",
                "Home & Living",
                "Wedding & Party",
                "Toys & Entertainment",
                "Art & Collectibles",
                "Craft Supplies",
                "Gifts & Gift Cards"};

        for (int i = 0; i < 9; i++) {
          Assert.assertEquals(etsySearchPage.meanHeaderLinks.get(i).getText(), expectedTexts[i]);
        }
    }
}