package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /**Variables*/
    String baseURL = "https://automationexercise.com/";

    /**Page Methods*/
    public HomePage goToHomePage() throws InterruptedException {
        driver.get(baseURL);
        driver.manage().window().maximize();
        Thread.sleep(8000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        return this;
    }

    public EcomPage goToEcomPage(){
        return new EcomPage(driver);
    }

}
