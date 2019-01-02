import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private static final String SITE_LINK = "https://www.s7.ru/en/";
    private WebDriver driver;
    private MainPageSteps mainPageSteps;
    private WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void openPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get(SITE_LINK);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        mainPageSteps = new MainPageSteps(new MainPage(driver, wait));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void oneCanNotSearchForRacesWithoutInputtingData() {
        mainPageSteps.searchRacesWithoutInputtingAnyText();

        Assert.assertTrue(mainPageSteps.hasErrorsOnPage());
    }

    @Test
    public void oneCanNotOrderAFlightForMoreThan9Adults() {
        String expected = "plus disabled";

        Assert.assertEquals(mainPageSteps.checkAdultsError(8), expected);
    }

    @Test
    public void oneCanNotFindNonexistentBooking() {
        mainPageSteps.enterBookingDataAndFind("adfasfasf", "12345");

        Assert.assertTrue(mainPageSteps.hasBookingError());
    }

    @Test
    public void oneCanAddOnlyOneInfantForOneAdult() {
        String expected = "plus disabled";
        String actual = mainPageSteps
                .addPassengers(0, 0, 2)
                .getInfantsError();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void oneCanOrderMaximum9AdultsAnd9Infants() {
        String expected = "plus disabled";

        mainPageSteps.addPassengers(8, 0, 9);

        String adultsError = mainPageSteps.getAdultsError();
        String infantsError = mainPageSteps.getInfantsError();

        Assert.assertEquals(adultsError, expected);
        Assert.assertEquals(infantsError, expected);
    }

    @Test
    public void oneHasToInputValidBookingId() {
        String actual = mainPageSteps
                .enterBookingDataAndFind("asdadfadsaf", "1")
                .getBookingIdError();

        Assert.assertFalse(actual.isEmpty());
    }

    @Test
    public void oneCanNotInsertInBookingId13Letters() {
        String error = mainPageSteps
                .enterBookingDataAndFind("adsfdsafsadf", "abcdefghijklm")
                .getBookingIdError();

        Assert.assertFalse(error.isEmpty());
    }

    @Test
    public void oneCanNotInsertLettersInFlightNumber() {
        String expected = "Please, use digits only";

        String error = mainPageSteps
                .goToFlightStatus()
                .checkFlightNumber()
                .insertFlightData("aaa")
                .getFlightNumberError();

        Assert.assertFalse(error.isEmpty());
    }

    @Test
    public void oneCanNotInsertNumbersInOnlineCheckInSurnameField() {
        String expected = "Use latin characters only";

        String actual = mainPageSteps
                .goToOnlineCheckIn()
                .insertOnlineCheckInDataAndSubmit("1", "")
                .getOnlineCheckInSurnameDataError();

        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void onlineCheckInFieldsCanNotBeEmpty() {
        mainPageSteps.goToOnlineCheckIn()
                .insertOnlineCheckInDataAndSubmit("", "");

        String surnameError = mainPageSteps.getOnlineCheckInSurnameDataError();
        String idError = mainPageSteps.getOnlineCheckInIdError();

        Assert.assertTrue(!surnameError.isEmpty());
        Assert.assertTrue(!idError.isEmpty());
    }
}
