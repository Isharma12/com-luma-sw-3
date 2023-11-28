package testsuite;
/**
 * 6.Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text
 *
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00’
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @After
    public void setUp() {
        openBrowser(baseUrl);

    }
    @Test
      public void userShouldAddProductsSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse hover on Gear menu
        mouseHoverOnElements(By.xpath("//span[normalize-space()='Gear']"));
        Thread.sleep(2000);
        //Click on bags
        clickMethod(By.xpath("//span[normalize-space()='Bags']"));
        //Click on Product name 'Overnight Duffle'
        clickMethod(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //Verify the text 'Overnight Duffle'
        String aProduct = getTextElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        String eProduct ="OverNight Duffle";
        Assert.assertEquals(eProduct, aProduct);

        //Change qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"),"3");
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String aMsg = getTextElement(By.xpath("/div[contains(text(),'Overnight')]"));
        String eMsg = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals(eMsg, aMsg);

        //Verify the product name 'OverNight Duffle'
        String eName = "Overnight Duffle";
        String aName = getTextElement(By.xpath("//a[text() = 'Overnight Duffle'])"));
        Assert.assertEquals(eName, aName);

        //Verify the qty '3'
        WebElement Qty = driver.findElement(By.xpath("//input[@title = 'Qty']"));
        String aQty = Qty.getAttribute("value");
        String eQty = "3";
        Assert.assertEquals(eQty, aQty);

        //Verify the product price '$135.00'
        String aPrice = getTextElement(By.xpath("//span[contains(text(),'$135.00')]"));
        String ePrice = "135.00";
        Assert.assertEquals(ePrice,aPrice);

        //Change qty to '5'
        Qty.clear();
        Qty.sendKeys("5");
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //Verify the product price '$225.00'
        String aTotal = getTextElement(By.xpath("//span[contains(text(),'$225.00')]"));
        String eTotal = "$225.00";
        Assert.assertEquals(eTotal, aTotal);


    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}




