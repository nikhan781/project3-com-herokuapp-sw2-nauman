package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    //Creating a method with one argument for reusing via Inheritance
    public void clickOnTheElement(By by) {
        WebElement clickLink = driver.findElement(by);
        clickLink.click();
    }

    //Creating a method with String type return type and one argument for reusing via Inheritance
    public String verifyText(By by) {
        WebElement actualTextMessage = driver.findElement(by);
        return actualTextMessage.getText();
    }

    //Creating a method with two argument for reusing via Inheritance
    public void enterTextInElement(By by, String requiredText) {

        driver.findElement(by).sendKeys(requiredText);
    }
}
