package amysimTesting;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class Payment extends BaseDriver {

    @Test(priority = 0)
    public void PaymentTest() {

        driver.get("https://www.amaysim.com.au/");
        WebElement SimPlanButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='SIM plans']")));
        action.moveToElement(SimPlanButton).perform();
        driver.findElement(By.xpath("(//a[contains(text(), '7 day SIM plans')])[1]")).click();
        WebElement BuyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Buy now']")));
        action.moveToElement(BuyNowButton).perform();
        action.click(BuyNowButton).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='css-15xa8x' and text()='pick a new number']"))).click();
        WebElement CheckOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='css-1957xzp']")));
        jse.executeScript("arguments[0].scrollIntoView(true);", CheckOutButton);
        action.click(CheckOutButton).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-input--4"))).sendKeys("Test"); //name
        driver.findElement(By.id("field-input--5")).sendKeys("Test"); //last name
        driver.findElement(By.id("field-input--6")).sendKeys("01022000"); // date of birth
        driver.findElement(By.id("field-input--7")).sendKeys("johnkevinc.delacruz@gmail.com");
        driver.findElement(By.id("field-input--8")).sendKeys("123456");
        driver.findElement(By.id("field-input--9")).sendKeys("0212345678");
        driver.findElement(By.id("field-input--16")).sendKeys("Level 6, 17-19 Bridge St, SYDNEY NSW 2000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autowhatever-1--item-0"))).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='payment-element']//iframe")));
        driver.findElement(By.xpath("//div[@aria-label='Payment Methods']//button[1]")).click();
        driver.findElement(By.xpath("//input[@id='Field-numberInput']")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.xpath("//input[@id='Field-expiryInput']")).sendKeys("0127");
        driver.findElement(By.xpath("//input[@id='Field-cvcInput']")).sendKeys("123");
        driver.switchTo().defaultContent();

        WebElement Terms = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='css-1417z9a'])[2]")));
        jse.executeScript("arguments[0].scrollIntoView(true);", Terms);
        action.click(Terms).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'pay now')]"))).click();

        String ActualValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='css-qib644'])[3]"))).getText();
        String ExpectedValue = "Your attempt to pay via Credit Card has failed. Please ensure you have enough funds and try again or use another credit card.";
        Assert.assertEquals(ActualValue, ExpectedValue);

        System.out.println(ActualValue);
        System.out.println(ExpectedValue);


    }


}
