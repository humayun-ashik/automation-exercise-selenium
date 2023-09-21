package automation.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage{
    public WebDriver driver;
    public WebDriverWait wait;
    public static Logger logger;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        logger = Logger.getLogger("kinetik");
        PropertyConfigurator.configure("log4j.properties");
        logger.info("------------------ AUTOMATED TEST EXECUTION STARTED ---------------");
    }

    //Click Method
    public void doClick(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    public void dropDownSelect(By elementLocation, String value) throws InterruptedException {
        Select optionSelect = new Select(driver.findElement(elementLocation));
        Thread.sleep(1000);
        optionSelect.selectByValue(value);
    }

    public static void scrollToElement(WebDriver driver, By elementLocation) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementLocation));
    }
    public static void scrollDownByPixels(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    // Define a method to scroll an element into view using JavaScript
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }

    //Wait
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeader(By locator) {
        return getElementBy(locator).getText();
    }

    public WebElement getElementBy(By locator) {
        WebElement element = null;

        try {
            element = driver.findElement(locator);
            return element;
        }catch(Exception e) {
            System.out.println("Some Error Occured while creating element"+locator.toString());
            e.printStackTrace();
        }

        return element;
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e) {
            System.out.println("some exception occured while waiting for the element "+locator.toString());
        }

    }

    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        }catch(Exception e) {
            System.out.println("some exception occured while waiting for the title "+title);
        }
    }

}
