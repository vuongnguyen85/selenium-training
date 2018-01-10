package Flights;

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

        clickElement(TestData.SkyScannerData.cssTravellers);
        int i = TestData.TripDetails.noOfAdults;
        for (int j=1;j<=i-1;j++) {
            clickElement("[class='increment adults']");
        }
        clickElement(TestData.SkyScannerData.cssTravellers);
    }

    public void clearOriginCityTextField() {
        findElement(TestData.SkyScannerData.cssOrigin).clear();
    }

    public void enterOriginCityInTextField() {
        enterText(TestData.SkyScannerData.cssOrigin, TestData.TripDetails.originCity);
    }

    public void selectOriginCityInDropdown() {
        clickElement("(.//*[@class='tt-dropdown-menu'])[1]/div/span/div/p");
    }

    public void enterDestinationCityInTextField() {
        enterText(TestData.SkyScannerData.cssDestination, TestData.TripDetails.destinationCity);
    }

    public void selectDestinationCityInDropdown() {
        clickElement("(.//*[@class='tt-dropdown-menu'])[2]/div/span/div/p");
    }

    public void clickDepartureDateTextField() {
        clickElement(TestData.SkyScannerData.cssDepartureDate);
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
        clickElement("[class='fss-bpk-button fss-bpk-button--large js-search-button']");
    }

    public void clearAllAirlineFilters() {
        clickElement("[class='clear-all']");
    }

    public void filterByAirline(String airline) {
        String LCAirline = airline.toLowerCase();

        switch (LCAirline) {
            case "emirates":
                clickElement(".//*[@data-id='-32348']/label/input");
                break;
            case "qatar":
                clickElement(".//*[@data-id='-31939']/label/input");
                break;
        }
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
        String currentMonth = findElement(path).getText();
        if (!(currentMonth.equals(returnMonthString))) {
            for (int i = 0; i < 12; i++) {
                String newCurrentMonth = findElement(path).getText();
                if (!(newCurrentMonth.contains(returnMonthString))) {
                    clickElement("(.//*[@class='calendar-info-bar datepicker_clearfix'])[2]/button[2]");
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

    public String xpathReturnDate(String date, String deptMonth) throws ParseException {

        String xpath = ".//*[@data-id='" + newDateFormat(date) + "']";
        firefoxBrowser.findElements(By.xpath(xpath)).size();
        return xpath;
    }

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
