package utilities;
/**
 * Create the package utilities and create the class
 * with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in
 * it’.
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * 1Method click method
     */
    // 1 Method click method
    public void clickMethod(By by) {
        driver.findElement(by).click();

    }
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {  //locator return type is By and by is variable
        driver.findElement(by).click();
    }


    /**
     * This method will send keys to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    /**
     * This method will get text from element
     */
    public String getTextElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will mouse hover over  on element
     */
    public void mouseHoverOnElements(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will mouse hover over element and click
     */

    public void mouseHoverElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * This method will verify text
     */

    public void verifyText(String displayMessage, String expectedText, String actualText) {
       Assert.assertEquals(displayMessage, expectedText, actualText);
    }

    /**
     * This method is used to select the option from drop down menu
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


}
