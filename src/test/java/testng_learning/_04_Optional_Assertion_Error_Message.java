package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Optional_Assertion_Error_Message {

    @Test
    public void method0(){
        //TestNG way
        //Assert.assertTrue(false, "Error message");
        Assert.assertEquals("", "","");

        //JUnit way
        org.junit.Assert.assertTrue("", false);
        org.junit.Assert.assertEquals("","","");

        //Just quickly check the argument and message order... but shouldn't get to confused bc work environment will use one (JUnit or TestNG)
    }
}
