package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUpload extends Base{

    /*
    Create a text file in your project called as “myFile.txt”
    Go to http://the-internet.herokuapp.com/
    Click on “File Upload” link
    Choose created file to be uploaded to the page
    Click on “Upload” button
    Validate “File Uploaded!” heading3 text
    Validate ”myFile.txt” in the uploaded file list
     */
    @Test(priority = 1, description = "File upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("File Upload");
        Waiter.pause(2);
        heroAppPage.chooseFileInputBox.sendKeys("/Users/techglobal/IdeaProjects/testng_framework/myFileTech2.xls");
        Waiter.pause(2);
        heroAppPage.uploadFileButton.click();
        Waiter.pause(2);

        //Locate 2 more elements
        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myFileTech2.xls");

    }


    /*
    Go to http://the-internet.herokuapp.com/
    Click on “File Download” link
    Click on “myFileTech2.xls” link
    Validate “myFileTech2.xls” file is downloaded in your “Downloads” folder
     */

    @Test(priority = 2, description = "File download")
    public void testFileDownload(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Download");

        heroAppPage.downloadFileLink.click();
        Waiter.pause(2);
    }
}