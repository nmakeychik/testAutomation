package by.bsu.alaska.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private By oneWayLocator = By.xpath("//*[@id=\"oneWay\"]");
    private By returnDateInputLocator = By.xpath("//*[@id=\"returnDate\"]");
    private By fromAirportInputField = By.xpath("//*[@id=\"fromCity1\"]");
    private By toAirportInputField = By.xpath("//*[@id=\"toCity1\"]");
    private By findFlisgtsButton = By.xpath("//*[@id=\"findFlights\"]");
    private By fromAndToCityAreTheSameErrorMessage = By.xpath("//*[@id=\"shopping_err_0\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.alaskaair.com/");
    }

    public void clickOneWay() {
        driver.findElement(oneWayLocator).click();
    }

    public boolean isReturnDateInputVisible() {
        return driver.findElement(returnDateInputLocator).isDisplayed();
    }

    public void setFromAirport(String fromAirportName) {
        driver.findElement(fromAirportInputField).clear();
        driver.findElement(fromAirportInputField).sendKeys(fromAirportName);
    }

    public void setToAirport(String toAirportName) {
        driver.findElement(toAirportInputField).clear();
        driver.findElement(toAirportInputField).sendKeys(toAirportName);
    }

    public void clickFindFlightsButton() {
        driver.findElement(findFlisgtsButton).click();
    }

    public boolean isfromAndToCityAreTheSameErrorMessageVisible() {
        return driver.findElement(fromAndToCityAreTheSameErrorMessage).isDisplayed();
    }
}
