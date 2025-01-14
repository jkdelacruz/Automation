package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BaseDriver {

    public static WebDriver driver;
    public Actions action;
    public static JavascriptExecutor jse;
    public WebDriverWait wait;


    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\CDP\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.action= new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        jse = (JavascriptExecutor) driver;

    }


}

