package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriverWait wait;
    private WebDriver driver;

    @FindBy(id = "search-btn-expand-bot")
    WebElement searchButton;

    @FindBy(id = "flights_destination2-error")
    WebElement airportToError;

    @FindBy(xpath = "//div[@id='date-opener2']/preceding-sibling::div[@class='error error-msg']")
    WebElement datesError;

    @FindBy(id = "aviaBotPassengers")
    private WebElement passengers;

    @FindBy(xpath = "//div[@tabindex='41']")
    private WebElement plusAdult;

    @FindBy(xpath = "//ul[@class='row resp-tabs-list resp-tabs-parent grid-flexible-size bot-tabs-top']/li[4]")
    private WebElement myBookingMenuItem;

    @FindBy(id = "from-input-bot6")
    private WebElement bookingSurname;

    @FindBy(id = "to-input-bot6")
    private WebElement bookingId;

    @FindBy(id = "manage-booking-submit")
    private WebElement bookingSubmit;

    @FindBy(xpath = "//h2/span[@class='error-msg']")
    private WebElement bookingError;

    @FindBy(xpath = "//div[@tabindex='43']")
    private WebElement addChildren;

    @FindBy(xpath = "//div[@tabindex='45']")
    private WebElement addInfants;

    @FindBy(id = "flights_destination2")
    private WebElement toAirport;

    @FindBy(xpath = "//*[@id='aviaBot']/div[2]/div[2]")
    private WebElement swapButton;

    @FindBy(xpath = "//*[@id=\"aviaBot\"]/div[2]/div[1]/div/div[1]/div/a/div[3]")
    private WebElement fromAirportText;

    @FindBy(id = "to-input-bot6-error")
    private WebElement bookingIdError;

    @FindBy(xpath = "//ul[@class='row resp-tabs-list resp-tabs-parent grid-flexible-size bot-tabs-top']/li[5]")
    private WebElement flightStatusMenuItem;

    @FindBy(xpath = "//div[@class='flight-status-bot_status-type-switcher']/div[2]/label")
    private WebElement flightNumberCheckBox;

    @FindBy(xpath = "//input[@class='form-control input-bordered flight-status-bot_flight-number-input']")
    private WebElement flightNumberInput;

    @FindBy(xpath = "//div[@class='row flight-status-bot_flight-number-search-view']/div[1]//div[@class='error error-msg']")
    private WebElement flightNumberError;

    @FindBy(xpath = "//ul[@class='row resp-tabs-list resp-tabs-parent grid-flexible-size bot-tabs-top']/li[3]")
    private WebElement onlineCheckInMenuItem;

    @FindBy(id = "from-input-bot4")
    private WebElement onlineCheckInSurnameInput;

    @FindBy(id = "from-input-bot4-error")
    private WebElement onlineCheckInSurnameDataError;

    @FindBy(id = "to-input-bot4")
    private WebElement onlineCheckInIdInput;

    @FindBy(id = "to-input-bot4-error")
    private WebElement onlineCheckInIdError;

    @FindBy(id = "check-in-submit")
    private WebElement onlineCheckInSubmit;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    private WebElement waitForVisabilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickabilityOf(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public MainPage searchRaces() {
        waitForVisabilityOf(searchButton).click();

        return this;
    }

    public boolean checkErrors() {
        try {
            String airportToErrorText = waitForVisabilityOf(airportToError).getText();
            String datesErrorText = waitForVisabilityOf(datesError).getText();

            return !airportToErrorText.isEmpty() && !datesErrorText.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public MainPage openPassengersDropdown() {
        passengers.click();
        return this;
    }

    public MainPage addAdults(int num) {
        for (int i = 0; i < num; i++) {
            waitForClickabilityOf(plusAdult).click();
        }

        return this;
    }

    public String getAdultsError() {
        return plusAdult.getAttribute("class");
    }

    public MainPage goToBooking() {
        waitForClickabilityOf(myBookingMenuItem).click();

        return this;
    }

    public MainPage enterBookingSurname(String surnameOrEmail) {
        waitForVisabilityOf(bookingSurname).sendKeys(surnameOrEmail);
        return this;
    }

    public MainPage enterBookingId(String bookingId) {
        waitForVisabilityOf(this.bookingId).sendKeys(bookingId);
        return this;
    }

    public void findBooking() {
        waitForClickabilityOf(bookingSubmit).click();
    }

    public boolean hasBookingError() {
        try {
            String errorText = waitForVisabilityOf(bookingError).getText();

            return !errorText.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public MainPage addChildren(int numberOfChildren) {
        for (int i = 0; i < numberOfChildren; i++) {
            waitForClickabilityOf(addChildren).click();
        }

        return this;
    }

    public MainPage addInfants(int numberOfInfants) {
        for (int i = 0; i < numberOfInfants; i++) {
            waitForClickabilityOf(addInfants).click();
        }

        return this;
    }

    public String getInfantsError() {
        return waitForVisabilityOf(addInfants).getAttribute("class");
    }

    public MainPage inputToAirport(String name) {
        waitForVisabilityOf(toAirport).sendKeys(name);
        waitForVisabilityOf(toAirport).sendKeys(Keys.RETURN);
        return this;
    }

    public MainPage swapAirports() {
        waitForVisabilityOf(swapButton).click();
        return this;
    }

    public String getFromAirportText() {
        return fromAirportText.getText();
    }

    public String getBookingIdError() {
        return waitForVisabilityOf(bookingIdError).getText();
    }

    public MainPage goToFlightStatus() {
        waitForClickabilityOf(flightStatusMenuItem).click();
        return this;
    }

    public MainPage checkFlightNumber() {
        waitForClickabilityOf(flightNumberCheckBox).click();
        return this;
    }

    public MainPage insertFlightNumber(String data) {
        waitForVisabilityOf(flightNumberInput).sendKeys(data);
        return this;
    }

    public String getFlightNumberError() {
        return waitForVisabilityOf(flightNumberError).getText();
    }

    public MainPage goToOnlineCheckIn() {
        waitForClickabilityOf(onlineCheckInMenuItem).click();
        return this;
    }

    public MainPage insertOnlineCheckInSurnameData(String surname) {
        waitForVisabilityOf(onlineCheckInSurnameInput).sendKeys(surname);
        return this;
    }

    public MainPage insertOnlineCheckInIdData(String id) {
        waitForVisabilityOf(onlineCheckInIdInput).sendKeys(id);
        return this;
    }

    public String getOnlineCheckInSurnameDataError() {
        return waitForVisabilityOf(onlineCheckInSurnameDataError).getText();
    }

    public String getOnlineCheckInIdError() {
        return waitForVisabilityOf(onlineCheckInIdError).getText();

    }

    public MainPage onlineCheckInSubmit() {
        waitForClickabilityOf(onlineCheckInSubmit).click();
        return this;
    }
}