package by.bsu.alaska.index;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlaskaTest {
    private WebDriver driver;

    @BeforeClass
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void isHideReturningDateChoiceAfterOneWayChoice() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOneWay();
        Assert.assertFalse(mainPage.isReturnDateInputVisible());
    }

    @Test
    public void isAbleToPreventOrderTicketWithSameFromAndToAirport() {
        MainPage mainPage = new MainPage(driver);
        String airportName = "New York, NY (JFK-Kennedy)";
        mainPage.setFromAirport(airportName);
        mainPage.setToAirport(airportName);
        mainPage.clickFindFlightsButton();
        Assert.assertTrue(mainPage.isfromAndToCityAreTheSameErrorMessageVisible());
    }
}
