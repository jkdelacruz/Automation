package amysimTesting;

import Utility.BaseDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class Payment extends BaseDriver {

    @Test(priority = 0)
    @Tag("Payment")
    @Description("To purchase a 7-day mobile plan using invalid credit card")
    @Severity(SeverityLevel.CRITICAL)
    public void PaymentTest() {

        driver.get("https://www.amaysim.com.au/");
        WebElement SimPlanButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='SIM plans']")));
        action.moveToElement(SimPlanButton).perform();

        //Highlight
        highlightElement(driver, SimPlanButton);
        ScreenshotToStep("Hover to Sim Plan navigation tab");
        removeHighlight(driver, SimPlanButton);

        WebElement SimPlan7Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), '7 day SIM plans')])[1]")));
        highlightElement(driver, SimPlan7Button);
        ScreenshotToStep("Click on 7 day SIM plans option");
        removeHighlight(driver, SimPlan7Button);
        action.click(SimPlan7Button).perform();

        WebElement BuyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Buy now']")));
        action.moveToElement(BuyNowButton).perform();
        highlightElement(driver, BuyNowButton);
        ScreenshotToStep("Click on Buy button");
        removeHighlight(driver, BuyNowButton);
        action.click(BuyNowButton).perform();

        WebElement PickANewNumberButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='css-15xa8x' and text()='pick a new number']")));
        highlightElement(driver, PickANewNumberButton);
        ScreenshotToStep("Click on Pick a new number button");
        removeHighlight(driver, PickANewNumberButton);
        action.click(PickANewNumberButton).perform();

        WebElement CheckOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='css-1957xzp']")));
        jse.executeScript("arguments[0].scrollIntoView(true);", CheckOutButton);
        highlightElement(driver, CheckOutButton);
        ScreenshotToStep("Click on Check out button");
        removeHighlight(driver, CheckOutButton);
        action.click(CheckOutButton).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-input--4"))).sendKeys("Test"); //name
        driver.findElement(By.id("field-input--5")).sendKeys("Test"); //last name
        driver.findElement(By.id("field-input--6")).sendKeys("01022000"); // date of birth
        driver.findElement(By.id("field-input--7")).sendKeys("johnkevinc.delacruz@gmail.com"); //email
        driver.findElement(By.id("field-input--8")).sendKeys("123456"); // password
        driver.findElement(By.id("field-input--9")).sendKeys("0212345678"); // contact details


        List<WebElement> InputDetails = List.of(
                driver.findElement(By.id("field-input--4")),
                driver.findElement(By.id("field-input--5")),
                driver.findElement(By.id("field-input--6")),
                driver.findElement(By.id("field-input--7")),
                driver.findElement(By.id("field-input--8")),
                driver.findElement(By.id("field-input--9"))
        );

        highlightElements(driver, InputDetails);
        ScreenshotToStep("Input Personal details");
        removeHighlights(driver, InputDetails);

        driver.findElement(By.id("field-input--16")).sendKeys("Level 6, 17-19 Bridge St, SYDNEY NSW 2000"); // address
        WebElement Address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id ("react-autowhatever-1--item-0")));
        highlightElement(driver, Address);
        ScreenshotToStep("Input Address");
        removeHighlight(driver, Address);
        action.click(Address).perform();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='payment-element']//iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//div[@aria-label='Payment Methods']//button[1]"))).click();
        driver.findElement(By.xpath("//input[@id='Field-numberInput']")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.xpath("//input[@id='Field-expiryInput']")).sendKeys("0127");
        driver.findElement(By.xpath("//input[@id='Field-cvcInput']")).sendKeys("123");

        List<WebElement> CreditCardDetails = List.of(
                driver.findElement(By.xpath("//div[@aria-label='Payment Methods']//button[1]")),
                driver.findElement(By.xpath("//input[@id='Field-numberInput']")),
                driver.findElement(By.xpath("//input[@id='Field-expiryInput']")),
                driver.findElement(By.xpath("//input[@id='Field-cvcInput']"))
        );

        highlightElements(driver, CreditCardDetails);
        ScreenshotToStep("Input Credit Card details");
        removeHighlights(driver, CreditCardDetails);
        driver.switchTo().defaultContent();


        WebElement Terms = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='css-1417z9a'])[2]")));
        jse.executeScript("arguments[0].scrollIntoView(true);", Terms);
        highlightElement(driver, Terms);
        ScreenshotToStep("Tick the Terms and Condition");
        removeHighlight(driver, Terms);
        action.click(Terms).perform();

        WebElement PayNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'pay now')]")));
        highlightElement(driver, PayNowButton);
        ScreenshotToStep("Click on Pay now button");
        removeHighlight(driver, PayNowButton);
        action.click(PayNowButton).perform();

        String ActualValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='css-qib644'])[3]"))).getText();
        String ExpectedValue = "Your attempt to pay via Credit Card has failed. Please ensure you have enough funds and try again or use another credit card.";
        Assert.assertEquals(ActualValue, ExpectedValue);

        System.out.println(ActualValue);
        System.out.println(ExpectedValue);

    }
}
