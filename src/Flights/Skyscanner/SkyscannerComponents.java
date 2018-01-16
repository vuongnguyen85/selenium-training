package Flights.Skyscanner;

import Flights.Util.TestData;
import Flights.Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SkyscannerComponents extends Utility {

    String deptMonthString = findMonthString(TestData.TripDetails.departureDate);
    String returnMonthString = findMonthString(TestData.TripDetails.returnDate);

    public void selectNoOfPassengers() {

        clickElement(TestData.SkyScannerData.TravellersField);
        int i = TestData.TripDetails.noOfAdults;
        for (int j=1;j<=i-1;j++) {
            clickElement(TestData.SkyScannerData.IncrementAdultsButton);
        }
        clickElement(TestData.SkyScannerData.TravellersField);
    }

    public void clearOriginCityTextField() {
        findElement(TestData.SkyScannerData.OriginCityField).clear();
    }

    public void enterOriginCityInTextField() {
        enterText(TestData.SkyScannerData.OriginCityField, TestData.TripDetails.originCity);
    }

    public void selectOriginCityInDropdown() {
        clickElement("(.//*[@class='tt-dropdown-menu'])[1]/div/span/div/p");
    }

    public void enterDestinationCityInTextField() {
        enterText(TestData.SkyScannerData.DestinationCityField, TestData.TripDetails.destinationCity);
    }

    public void selectDestinationCityInDropdown() {
        clickElement("(.//*[@class='tt-dropdown-menu'])[2]/div/span/div/p");
    }

    public void clickDepartureDateTextField() {
        clickElement(TestData.SkyScannerData.DepartureDateField);
    }

    public void selectDepartureDateOnCalendar() throws ParseException {
        clickElement(CalendarDateDeptXpath(TestData.TripDetails.departureDate));
    }

    public void clickReturnDateTextField() {
        clickElement("#js-return-input");
    }

    public void selectMonthForReturnDate() throws ParseException {
        selectMonthRet("(.//*[@class='current'])[2]");
    }

    public void selectReturnDateOnCalendar() throws ParseException {
        clickElement(CalendarDateRetXpath(TestData.TripDetails.returnDate));
    }

    public void clickSearch() {
        clickElement(TestData.SkyScannerData.SearchButton);
    }

    public void clearAllAirlineFilters() {
        clickElement("[class='clear-all']");
    }

    public void filterByAirline(String airline) {
        String LCAirline = airline.toLowerCase();

        switch (LCAirline) {
            case "emirates":
                clickElement(airlineFilterPath(32348));
                break;
            case "qatar":
                clickElement(airlineFilterPath(31939));
                break;
        }
    }

    private String airlineFilterPath(int airlineFilterId) {
        String StringAirlineId = Integer.toString(airlineFilterId);
        String fullPath = ".//*[@data-id='-" + StringAirlineId + "']/label/input";
        return fullPath;
    }

    public String findMonthString(String departureDate) {
        String month = departureDate.substring(3, 5);
        int intMonth = Integer.parseInt(month);
        String monthString = new DateFormatSymbols().getMonths()[intMonth - 1];
        return monthString;
    }

    public String selectMonthForDeparture() {
        for (int i = 0; i < 12; i++) {
            String currentMonth = findElement("[class='current']").getText();
            if (!(currentMonth.contains(deptMonthString))) {
                clickElement(".//*[@class='calendar-info-bar datepicker_clearfix']/button[2]");
            }
        }
        String selectedMonth = firefoxBrowser.findElement(By.cssSelector("[class='current']")).getText();
        return selectedMonth;
    }


    public void selectMonthRet(String path) {
        String currentMonthYear = findElement(path).getText();
        if (!(currentMonthYear.equals(returnMonthString))) {
            for (int i = 0; i < 12; i++) {
                String newCurrentMonthYear = findElement(path).getText();
                if (!(newCurrentMonthYear.contains(returnMonthString))) {
                    clickElement(TestData.SkyScannerData.NextArrowOnReturnCalendar);
                }
            }
        }
    }

    public static String newDateFormat(String oldDate) throws ParseException {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = newDateFormat.parse(oldDate);
        newDateFormat.applyPattern("yyyy-MM-dd");
        String newFormattedDate = newDateFormat.format(myDate);
        return newFormattedDate;
    }

    public String CalendarDateDeptXpath(String date) throws ParseException {
        String newXpath = ".//*[@data-id='" + newDateFormat(date) + "']";
        return newXpath;
    }

    //clickXpath(CalendarDateReturnSameMonthXpath(TripDetails.returnDate));

    public String CalendarDateRetXpath(String date) throws ParseException {
        String xpathForSingleIncident = ".//*[@data-id='" + newDateFormat(date) + "']";
        if ((firefoxBrowser.findElements(By.xpath(xpathForSingleIncident)).size())==2) {
            String xpathForDoubleIncidents = "(.//*[@data-id='" + newDateFormat(date) + "'])[2]";
            return xpathForDoubleIncidents;
        } else {
            return xpathForSingleIncident;
        }
    }

    public void sortFlightResultsByPrice() {
        Select s = new Select(firefoxBrowser.findElement(By.id("sort-select")));
        s.selectByValue("price");
    }
}
