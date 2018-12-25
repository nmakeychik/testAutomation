package steps;

import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage;

    public MainPageSteps(MainPage page) {
        mainPage = page;
    }

    public MainPageSteps findFlights() {
        mainPage.clickSearchButton();
        return this;
    }

    public String getErrorText() {
        return mainPage.getErrorText();
    }

    public MainPageSteps chooseOneWay() {
        mainPage.clickOneWay();
        return this;
    }

    public boolean isReturnAirportVisible() {
        return mainPage.isReturnDateInputVisible();
    }

    public void setFromAirport(String fromAirport) {
        mainPage.setFromAirport(fromAirport);
    }

    public void setToAirport(String toAirport) {
        mainPage.setToAirport(toAirport);
    }

    public void clickFindFlightsButton() {
        mainPage.clickFindFlightsButton();
    }

    public boolean isFromAndToCityAreTheSameErrorMessageVisible() {
        return mainPage.isFromAndToCityAreTheSameErrorMessageVisible();
    }

    public MainPageSteps openChoosePassengersDropDown() {
        mainPage.openChoosePassengersDropDown();
        return this;
    }

    public void setInfants(int children) {
        mainPage.setInfants(children);
    }

    public MainPageSteps setAdults(int adults) {
        mainPage.setAdults(adults);
        return this;
    }

    public boolean isErrorVisible() {
        return mainPage.isFromAndToCityAreTheSameErrorMessageVisible();
    }

    public MainPageSteps setChildren(int children) {
        mainPage.setChildren(children);
        return this;
    }

    public MainPageSteps openHotels() {
        mainPage.clickHotels();
        return this;
    }

    public boolean isHotelsRoomNumberInputVisible() {
        return mainPage.isHotelsRoomNumberInputVisible();
    }

    public MainPageSteps openCheckInMenu() {
        mainPage.clickCheckInMenu();
        return this;
    }

    public void findCheckIn() {
        mainPage.chickFindCheckIn();
    }

    public boolean isCheckInErrorVisible() {
        return mainPage.isCheckInErrorVisible();
    }

    public MainPageSteps openCarsTab() {
        mainPage.clickCarsTab();
        return this;
    }

    public boolean isPickUpVisible() {
        return mainPage.isPickUpInputVisible();
    }

    public MainPageSteps openManageTripTab() {
        mainPage.clickManageTripTab();
        return this;
    }

    public MainPageSteps inputPassengerName(String name) {
        mainPage.inputPassengerName(name);
        return this;
    }

    public MainPageSteps inputConfirmationCode(String code) {
        mainPage.inputConfirmationCode(code);
        return this;
    }

    public boolean isConfirmationCodeErrorVisible() {
        return mainPage.isConfirmationCodeErrorVisible();
    }
}
