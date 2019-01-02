package steps;

import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage;

    public MainPageSteps(MainPage page) {
        mainPage = page;
    }

    public void searchRacesWithoutInputtingAnyText() {
        mainPage.searchRaces();
    }

    public boolean hasErrorsOnPage() {
        return mainPage.checkErrors();
    }

    public String checkAdultsError(int numberOfAdults) {
        return addPassengers(numberOfAdults, 0, 0)
                .getAdultsError();
    }

    public MainPageSteps enterBookingDataAndFind(String surnameOrEmail, String orderId) {
        mainPage.goToBooking()
                .enterBookingSurname(surnameOrEmail)
                .enterBookingId(orderId)
                .findBooking();
        return this;
    }

    public String getBookingIdError() {
        return mainPage.getBookingIdError();
    }

    public boolean hasBookingError() {
        return mainPage.hasBookingError();
    }

    public MainPageSteps addPassengers(int numberOfAdults, int numberOfChildren, int numberOfInfants) {
        mainPage.openPassengersDropdown()
                .addAdults(numberOfAdults)
                .addChildren(numberOfChildren)
                .addInfants(numberOfInfants);

        return this;
    }

    public String getAdultsError() {
        return mainPage.getAdultsError();
    }

    public String getInfantsError() {
        return mainPage.getInfantsError();
    }

    public MainPageSteps inputToAirportAndSwap(String name) {
        mainPage.inputToAirport(name)
                .swapAirports();

        return this;
    }

    public String getFromAirportText() {
        return mainPage.getFromAirportText();
    }

    public MainPageSteps goToFlightStatus() {
        mainPage.goToFlightStatus();
        return this;
    }

    public MainPageSteps insertFlightData(String data) {
        mainPage.insertFlightNumber(data);
        return this;
    }

    public MainPageSteps checkFlightNumber() {
        mainPage.checkFlightNumber();
        return this;

    }

    public String getFlightNumberError() {
        return mainPage.getFlightNumberError();
    }

    public MainPageSteps goToOnlineCheckIn() {
        mainPage.goToOnlineCheckIn();
        return this;
    }

    public MainPageSteps insertOnlineCheckInDataAndSubmit(String surname, String id) {
        mainPage.insertOnlineCheckInSurnameData(surname)
                .insertOnlineCheckInIdData(id)
                .onlineCheckInSubmit();
        return this;
    }

    public String getOnlineCheckInSurnameDataError() {
        return mainPage.getOnlineCheckInSurnameDataError();
    }

    public String getOnlineCheckInIdError() {
        return mainPage.getOnlineCheckInIdError();
    }
}
