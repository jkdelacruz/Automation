package Utility;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;


import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;



public class BaseDriver {

    public static WebDriver driver;
    public Actions action;
    public static JavascriptExecutor jse;
    public WebDriverWait wait;


    @BeforeClass
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\CDP\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.action= new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        jse = (JavascriptExecutor) driver;

    }

    // For Screenshot
    public static void Screenshot() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }

    // Capture Screenshot and Attach to Allure Step
    public static void ScreenshotToStep(String stepDescription) {
        Allure.step(stepDescription, () -> {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(stepDescription + " - Screenshot", new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                Allure.addAttachment(stepDescription + " - Error", "Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
    public static void highlightElement(WebDriver driver, WebElement element) {
        jse.executeScript("arguments[0].style.setProperty('border', '3px solid red', 'important');", element);
    }

    public static void highlightElements(WebDriver driver, List<WebElement> elements) {
        for (WebElement element : elements) {
            jse.executeScript("arguments[0].style.setProperty('border', '3px solid red', 'important');", element);
        }
    }

    public static void removeHighlight(WebDriver driver, WebElement element) {
        jse.executeScript("arguments[0].style.setProperty('border', '', 'important');", element);
    }

    public static void removeHighlights(WebDriver driver, List<WebElement> elements) {
        for (WebElement element : elements) {
            jse.executeScript("arguments[0].style.setProperty('border', '', 'important');", element);
        }

    }


}

