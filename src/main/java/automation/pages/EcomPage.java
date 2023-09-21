package automation.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EcomPage extends BasePage{
    Faker faker = new Faker();

    String loggedInUserName = "";
    private By logo = By.className("logo");
    private By productOverlay = By.xpath("//div[@class='product-overlay']");
    private By addToCartButtonElement = By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]");
    private By viewCartButtonElement = By.xpath("//u[normalize-space()='View Cart']");
    private By shoppingCartElement = By.xpath("//li[@class='active']");
    private By checkoutButton = By.className("check_out");
    private By registerButton = By.xpath("//u[normalize-space()='Register / Login']");
    private By nameInput = By.cssSelector("input[placeholder='Name']");
    private By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By titleRadio = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyNameInput = By.id("company");
    private By addressInput = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNoInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[normalize-space()='Create Account']");
    private By accountCreatedElement = By.xpath("//*[@id=\"form\"]/div/div/div/h2");
    private By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private By loggedInUser = By.cssSelector("ul[class='nav navbar-nav'] li a b");
    private By cartButton = By.cssSelector("body > header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    private By deliveryAddress = By.id("address_delivery");
    private By addressDetails = By.xpath("//h2[normalize-space()='Address Details']");
    private By review = By.xpath("//h2[normalize-space()='Review Your Order']");
    private By invoiceAddress = By.id("address_invoice");
    private By messageInput = By.name("message");
    private By placeOrderButton = By.xpath("//a[@class='btn btn-default check_out']");
    private By nameOnCardInput = By.name("name_on_card");
    private By cardNoInput = By.name("card_number");
    private By cvcInput = By.name("cvc");
    private By expiryMonthDropdown = By.name("expiry_month");
    private By expiryYearDropdown = By.name("expiry_year");
    private By payConfirmButton = By.id("submit");
    //#success_message > div

    private By paymentSuccessMsg = By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");

    public EcomPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed(){
        return this.driver.findElement(By.className("logo")).isDisplayed();
    }
    public EcomPage isHomePageVisible(){
        String expectedTitle = "Automation Exercise";
        boolean isLogoDisplayed = isLogoDisplayed();
        logger.info("Logo displayed? - "+isLogoDisplayed);
        Assert.assertEquals(this.driver.getTitle(), expectedTitle, "Home page is not visible successfully as title is not matched");
        Assert.assertTrue(isLogoDisplayed(), "Home page is not visible successfully as logo is not displayed.");
        return this;

    }
    public EcomPage isCartPageDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        scrollDownByPixels(driver, 400);
        logger.info("Scrolled down to 300 pixels");
        Thread.sleep(3000);
        WebElement parentElement = driver.findElement(By.xpath("//div[@class='product-overlay']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(parentElement).build().perform();
        try {
            Thread.sleep(2000);
            logger.info("Hover element triggered");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='features_items']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]"));
        addToCartButton.click();
        logger.info("Add to Cart button is clicked");
        Thread.sleep(4000);
        WebElement viewCartButton = driver.findElement(By.xpath("//u[normalize-space()='View Cart']"));
        viewCartButton.click();
        logger.info("View Cart button is clicked");
        return this;
    }
    public EcomPage isAccountCreated() throws InterruptedException {
        loggedInUserName = faker.name().fullName();
        Thread.sleep(3000);
        doClick(checkoutButton);
        logger.info("Proceed to Checkout button clicked");
        doClick(registerButton);
        logger.info("Register button clicked");
        logger.info("Started filling up registration form");
        writeText(nameInput, loggedInUserName);
        writeText(emailInput, faker.name().lastName()+"@yopmail.com");
        doClick(signupButton);
        doClick(titleRadio );
        writeText(passwordField, "Kinetik@123");
        dropDownSelect(daysDropdown ,"1");
        dropDownSelect(monthsDropdown ,"1");
        dropDownSelect(yearsDropdown ,"1995");
        writeText(firstNameInput , faker.name().firstName());
        writeText(lastNameInput , faker.name().lastName());
        writeText(companyNameInput , "Kinetik");
        writeText(addressInput , faker.company().name());
        dropDownSelect(countryDropdown,"United States");
        writeText(stateInput , faker.address().state());
        writeText(cityInput , faker.address().city());
        writeText(zipcodeInput , faker.address().zipCode());
        writeText(mobileNoInput , faker.phoneNumber().cellPhone());
        scrollToElement(driver,createAccountButton );
        doClick(createAccountButton);
        String accCreatedText = readText(accountCreatedElement);
        Assert.assertEquals(accCreatedText,"ACCOUNT CREATED!");
        logger.info("Account created successfully");
        doClick(continueButton);
        logger.info("Continue button clicked");
        return this;
    }

    public EcomPage isLoggedInUserNameCorrect(){
        String userName = readText(loggedInUser);
        Assert.assertEquals(userName,loggedInUserName);
        logger.info("Logged in user verified");
        return this;
    }

    public EcomPage isAddressVerified(){
        doClick(cartButton);
        doClick(checkoutButton);
        Assert.assertTrue(driver.findElement(addressDetails).isDisplayed());
        logger.info("Address details verified");
        Assert.assertTrue(driver.findElement(review).isDisplayed());
        logger.info("Order reviewed");
        return this;
    }
    public EcomPage enterDescription(){
        writeText(messageInput, "Make a quick delivery");
        logger.info("Some description added ");
        return this;
    }
    public EcomPage clickPlaceOrder(){
        doClick(placeOrderButton);
        logger.info("Place order button clicked");
        return this;
    }
    public EcomPage enterPaymentDetails(){
        logger.info("Started inserting payment info");
        writeText(nameOnCardInput, "Humayun Ahmed Ashik");
        writeText(cardNoInput, "3700000000000002");
        writeText(cvcInput, "7373");
        writeText(expiryMonthDropdown, "03");
        writeText(expiryYearDropdown, "30");
        logger.info("Done inserting payment info");
        return this;
    }
    public EcomPage clickPayConfirmButton(){
        doClick(payConfirmButton);
        logger.info("Pay and confirm button clicked");
        return this;
    }
    public EcomPage verifySuccessMessage(){
        String messageText =  driver.findElement(paymentSuccessMsg).getText();;
        Assert.assertEquals(messageText,"Congratulations! Your order has been confirmed!");
        logger.info("Success message verified");
        return this;
    }



}
