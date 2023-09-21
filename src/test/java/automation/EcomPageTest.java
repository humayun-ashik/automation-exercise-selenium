package automation;


import org.testng.annotations.Test;

public class EcomPageTest extends BaseTest{

    @Test(testName = "TC-01")
    public void testAutomation() throws InterruptedException {
        homePage
                .goToHomePage()
                .goToEcomPage()
                .isHomePageVisible()
                .isCartPageDisplayed()
                .isAccountCreated()
                .isLoggedInUserNameCorrect()
                .isAddressVerified()
                .enterDescription()
                .clickPlaceOrder()
                .enterPaymentDetails()
                .clickPayConfirmButton()
                .verifySuccessMessage()

        ;

    }

}
