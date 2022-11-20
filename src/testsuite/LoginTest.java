package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    //Setting up and opening the browser after each test
    @Before
    public void browserSettingAndOpening() {
        //Enter url and one of the browser 'Chrome', 'Firefox', 'Edge' in the arguments
        browserSetup("http://the-internet.herokuapp.com/login", "Edge");
    }

    //Test 1.
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Entering username
        enterTextInElement(By.name("username"), "tomsmith");
        //Entering password
        enterTextInElement(By.name("password"), "SuperSecretPassword!");

        //Clicking on the login button
        clickOnTheElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']"));

        //Verify the text "Secure Area"
        String expectedText = "Secure Area";
        String actualText = verifyText(By.xpath("//h2[text() =' Secure Area']"));
        Assert.assertEquals(expectedText, actualText);
    }

    //Test 2.
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Entering username
        enterTextInElement(By.name("username"), "tomsmith1");
        //Entering password
        enterTextInElement(By.name("password"), "SuperSecretPassword!");

        //Clicking on the login button
        clickOnTheElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']"));

        //Verify the text
        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = verifyText(By.xpath("//div[1]/div/div|/text()"));
        Assert.assertEquals(expectedText, actualText);

    }

    //Test 3.
    @Test
    public void verifyThePasswordErrorMessage() {
        //Entering username
        enterTextInElement(By.name("username"), "tomsmith");
        //Entering password
        enterTextInElement(By.name("password"), "SuperSecretPassword");

        //Clicking on the login button
        clickOnTheElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']"));

        //Verify the text "Secure Area"
        String expectedText = "Your password is invalid!\n"+
                "×";
        String actualText = verifyText(By.xpath("//div[1]/div/div|/text()"));
        Assert.assertEquals(expectedText, actualText);

    }

    //CLosing the browser after each test
    @After
    public void closeTheBrowser() {
        closingTheBrowser();
    }
}
