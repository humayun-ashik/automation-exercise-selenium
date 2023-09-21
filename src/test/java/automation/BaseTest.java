package automation;

import automation.pages.EcomPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import automation.pages.HomePage;
import automation.utils.ReadConfig;

import java.io.File;

/**
 * @author Humayun Ahmed Ashik
 *
 */

public class BaseTest {
    static ReadConfig readconfig = new ReadConfig();
    public WebDriver driver;
    public HomePage homePage;
    public static Logger logger;
    public EcomPage ecomPage;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters(value= {"browser"})
    public void classLevelSetup(String browser) {
        logger = Logger.getLogger("kinetik");
        PropertyConfigurator.configure("log4j.properties");
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File(readconfig.getAddBlockPath()));
            driver = new ChromeDriver(options);
        }
        else {
            System.out.println("No Browser is Defined in xml");
        }

    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
