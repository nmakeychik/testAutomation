import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class MainTest {
    // ссылка на сайт
    private static final String SITE_LINK = "https://www.alaskaair.com";
    private WebDriver driver;
    private MainPageSteps mainPageSteps;
    private WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void openPage() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                .addArguments("--start-maximized");
        // создаем объект драйвера, который будет гулять по странице
        driver = new ChromeDriver(options);
        // создаем штуку которая будет ждать пока страница загрузится
        wait = new WebDriverWait(driver, 30);
        // идем на страницу
        driver.get(SITE_LINK);
        // размеры окна ставим 1400 на 900
        driver.manage().window().setSize(new Dimension(1400, 900));
        // ждем если что 60 секунд пока загрузится
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void oneCanNotOrderAFlightIfNoDataWasInputted() {
        String errorText = mainPageSteps
                .findFlights()
                .getErrorText();

        Assert.assertEquals(errorText, "The following fields are required: from city, to city");
    }

    @Test
    public void ifChosenOneWayThenDestinationWillNotBeShown() {
        mainPageSteps.chooseOneWay();

        Assert.assertFalse(mainPageSteps.isReturnAirportVisible());
    }

    @Test
    public void isAbleToPreventOrderTicketWithSameFromAndToAirport() {
        String airportName = "New York, NY (JFK-Kennedy)";

        mainPageSteps.setFromAirport(airportName);
        mainPageSteps.setToAirport(airportName);
        mainPageSteps.clickFindFlightsButton();

        Assert.assertTrue(mainPageSteps.isFromAndToCityAreTheSameErrorMessageVisible());
    }

    @Test
    public void oneCanNotOrderAFlightOnlyWithChildren() {
        mainPageSteps.openChoosePassengersDropDown()
                .setAdults(0)
                .setInfants(3);

        Assert.assertTrue(mainPageSteps.isErrorVisible());
    }

    @Test
    public void oneCanNotOrderAFlightFor2AdultsAnd5Infants() {
        mainPageSteps.openChoosePassengersDropDown()
                .setAdults(2)
                .setInfants(5);

        Assert.assertTrue(mainPageSteps.isErrorVisible());
    }

    @Test
    public void oneCanNotOrderAFlightForMoreThan7Children() {
        mainPageSteps.openChoosePassengersDropDown()
                .setAdults(0)
                .setChildren(8);

        Assert.assertTrue(mainPageSteps.isErrorVisible());
    }

    @Test
    public void oneCanSeeRoomsNumberInputIfClicksOnHotelsSection() {
        mainPageSteps.openHotels();

        Assert.assertTrue(mainPageSteps.isHotelsRoomNumberInputVisible());
    }

    @Test
    public void oneWillSeeErrorIfDoNotInputDataInCheckInAndClickFind() {
        mainPageSteps.openCheckInMenu()
                .findCheckIn();

        Assert.assertTrue(mainPageSteps.isCheckInErrorVisible());
    }

    @Test
    public void oneCanSeePickUpLocationIfClicksOnCars() {
        mainPageSteps.openCarsTab();

        Assert.assertTrue(mainPageSteps.isPickUpVisible());
    }

    @Test
    public void oneWillSeeErrorIfInputsNotValidConfirmationCodeInManageTripTab() {
        mainPageSteps.openManageTripTab()
                .inputPassengerName("1231231")
                .inputConfirmationCode("1231312312312");

        Assert.assertTrue(mainPageSteps.isConfirmationCodeErrorVisible());
    }


}
