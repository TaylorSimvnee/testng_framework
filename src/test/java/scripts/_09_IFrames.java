package scripts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _09_IFrames extends Base {
    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Frames” link
    Click on “iFrame” link
    Clear text “Your content goes here.” in the content box
    Enter “Hello World” in the content box
    Validate the text of the content box is “Hello World”
    Validate the heading3 as “An iFrame containing the TinyMCE WYSIWYG Editor”
     */


    @Test(priority = 1)
    public void testIFrame1() {
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("Frames");
        Waiter.pause(2);
        heroAppPage.iFrameLink.click();
        Waiter.pause(2);

        //switch to inner html - iframe
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(heroAppPage.innerIFrame);

        heroAppPage.contentBox.clear();
        Waiter.pause(2);
        heroAppPage.contentBox.sendKeys("Hello World");
        Assert.assertEquals(heroAppPage.contentBox.getText(), "Hello World");

        //Switch back to parent html - outer
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        Assert.assertEquals(heroAppPage.iFrameHeading3.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }


    /*
    Go to https://www.rediff.com/
    Validate money iFrame displayed with cell one and cell two
     */
    @Test(priority = 2)
    public void testIFrame2() {
        driver.get("https://www.rediff.com/");

        driver.switchTo().frame(rediffHomePage.moneyIFrame);
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("moneyiframe");

        for (WebElement element : rediffHomePage.moneyCells) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
