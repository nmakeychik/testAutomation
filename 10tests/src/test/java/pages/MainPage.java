package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriverWait wait;
    private WebDriver driver;

    @FindBy(id = "findFlights")
    private WebElement searchButton;

    @FindBy(id = "shopping_err_0")
    private WebElement flightErrorText;

    @FindBy(id = "oneWay")
    private WebElement oneWay;

    @FindBy(id = "returnDate")
    private WebElement returnAirportInput;

    @FindBy(id = "fromCity1")
    private WebElement fromAirportInput;

    @FindBy(id = "toCity1")
    private WebElement toAirportInput;

    @FindBy(id = "shopping_err_0")
    private WebElement citiesError;

    @FindBy(id = "childrenCountDropDown")
    private WebElement passengersDropDown;

    @FindBy(id = "infantPlus")
    private WebElement InfantsPlus;

    @FindBy(id = "adultCount")
    private WebElement setAdultsInput;

    @FindBy(xpath = "//svg[@id='childrenMinus']/following-sibling::svg")
    private WebElement childrenPlus;

    @FindBy(id = "tab-hotels")
    private WebElement hotelsButton;

    @FindBy(id = "hotelRoomsNum")
    private WebElement hotelsRoomNumberInput;

    @FindBy(id = "navHeaderCheckin")
    private WebElement checkInMenuItem;

    @FindBy(xpath = "//input[@name='CheckinBtn']")
    private WebElement findCheckInButton;

    @FindBy(id = "desktop-checkin-error-departure")
    private WebElement checkInError;

    @FindBy(id = "tab-cars")
    private WebElement carsTab;

    @FindBy(id = "carOnlyToLocation")
    private WebElement pickUpCarsInput;

    @FindBy(id = "tab-manage")
    private WebElement manageTripTab;

    @FindBy(xpath = "//div[@id='manage']//input[1]")
    private WebElement passengerNameInput;

    @FindBy(xpath = "//div[@id='manage']//input[2]")
    private WebElement confirmationIdInput;

    @FindBy(id = "ErrorCodeOrNumber")
    private WebElement confirmationCodeError;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Ждет появления элемента
     *
     * @param element
     * @return
     */
    private WebElement waitForVisabilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Ждет пока элемент станет кликабелиным
     *
     * @param element
     * @return
     */
    private WebElement waitForClickabilityOf(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public MainPage clickSearchButton() {
        waitForVisabilityOf(searchButton).click();

        return this;
    }

    public String getErrorText() {
        return waitForVisabilityOf(flightErrorText).getText();
    }

    public MainPage clickOneWay() {
        waitForClickabilityOf(oneWay).click();
        return this;
    }

    public boolean isReturnDateInputVisible() {
        return returnAirportInput.isDisplayed();
    }

    public void setFromAirport(String fromAirport) {
        waitForVisabilityOf(fromAirportInput).clear();
        waitForVisabilityOf(fromAirportInput).sendKeys(fromAirport);
    }

    public void setToAirport(String toAirport) {
        waitForVisabilityOf(toAirportInput).clear();
        waitForVisabilityOf(toAirportInput).sendKeys(toAirport);
    }

    public void clickFindFlightsButton() {
        waitForClickabilityOf(searchButton).click();
    }

    public boolean isFromAndToCityAreTheSameErrorMessageVisible() {
        return waitForVisabilityOf(citiesError).isDisplayed();
    }

    public MainPage openChoosePassengersDropDown() {
        waitForVisabilityOf(passengersDropDown).click();
        return this;
    }

    public MainPage setInfants(int children) {
        for (int i = 0; i < children; i++) {
            waitForClickabilityOf(InfantsPlus).click();
        }

        return this;
    }

    public MainPage setAdults(int adults) {
        new Select(waitForClickabilityOf(setAdultsInput)).selectByIndex(adults);

        return this;
    }

    public MainPage setChildren(int children) {
        for (int i = 0; i < children; i++) {
            waitForClickabilityOf(childrenPlus).click();
        }
        return this;
    }

    public void clickHotels() {
        waitForClickabilityOf(hotelsButton).click();
    }

    public boolean isHotelsRoomNumberInputVisible() {
        return waitForVisabilityOf(hotelsRoomNumberInput).isDisplayed();
    }

    public void clickCheckInMenu() {
        waitForClickabilityOf(checkInMenuItem).click();
    }

    public void chickFindCheckIn() {
        waitForClickabilityOf(findCheckInButton).click();
    }

    public boolean isCheckInErrorVisible() {
        return waitForVisabilityOf(checkInError).isDisplayed();
    }

    public void clickCarsTab() {
        waitForClickabilityOf(carsTab).click();
    }

    public boolean isPickUpInputVisible() {
        return waitForVisabilityOf(pickUpCarsInput).isDisplayed();
    }

    public void clickManageTripTab() {
        waitForClickabilityOf(manageTripTab).click();
    }

    public void inputPassengerName(String name) {
        waitForVisabilityOf(passengerNameInput).sendKeys(name);
    }

    public void inputConfirmationCode(String code) {
        waitForVisabilityOf(confirmationIdInput).sendKeys(code);
    }

    public boolean isConfirmationCodeErrorVisible() {
        return waitForVisabilityOf(confirmationCodeError).isDisplayed();
    }
}