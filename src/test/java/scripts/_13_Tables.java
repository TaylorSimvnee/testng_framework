package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _13_Tables extends Base{
/*
Go to http://the-internet.herokuapp.com/
Click on "Sortable Data Tables" link
Validate the table 1 headers to be displayed as below
Last Name
First Name
Email
Due
Web Site
Action
 */

    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        //Locate a List of web elements that returns all 6 headers and validate their texts with expected texts
        Waiter.pause(10);
    }

    /*
    Go to http://the-internet.herokuapp.com/
        Click on “Sortable Data Tables” link
        Validate the table 1 row 1 to be displayed as below
        Smith
        John
        jsmith@gmail.com
        $50.00
        http://www.jsmith.com
        edit delete
     */

    @Test(priority = 2, description = "Tables | First Row")
    public void testFirstRow(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] table1Row1Text = { "Smith",
                               "John",
                              "jsmith@gmail.com",
                              "$50.00",
                              "http://www.jsmith.com",
                              "edit delete"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(heroAppPage.table1Row1.get(i).getText(), table1Row1Text[i]);
        }
    }
//
//    @Test(priority = 3, description = "Tables | 2nd column")
//    public void testSecondColumn(){
//        driver.get("http://the-internet.herokuapp.com/");
//        heroAppPage.clickOnLink("Sortable Data Tables");
//
//        String[]
//
//        for (int i = 0; i < 4; i++) {
//            Assert.assertEquals(heroAppPage.table1Column2.get(i).getText(), );
//        }
//    }


}
