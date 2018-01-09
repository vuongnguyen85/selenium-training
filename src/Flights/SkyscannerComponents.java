package Flights;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SkyscannerComponents extends Utility {
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

    public void selectReturnDateOnCalendar(String deptMonth) throws ParseException {
        clickElement(CalendarDateRetXpath(TestData.TripDetails.returnDate, deptMonth));
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


    //
    //

    public String findMonthString(String departureDate) {
        String month = departureDate.substring(3, 5);
        int intMonth = Integer.parseInt(month);
        String monthString = new DateFormatSymbols().getMonths()[intMonth - 1];
        return monthString;
    }

    public String selectMonthForDeparture() {

        String monthString = findMonthString(TestData.TripDetails.departureDate);

        for (int i = 0; i < 12; i++) {
            String currentMonth = firefoxBrowser.findElement(By.cssSelector("[class='current']")).getText();
            if (!(currentMonth.contains(monthString))) {
                //click("button[class='next']");

                Utility.clickElement(".//*[@class='calendar-info-bar datepicker_clearfix']/button[2]");
                i++;
            }
        }
        String selectedMonth = firefoxBrowser.findElement(By.cssSelector("[class='current']")).getText();
        return selectedMonth;
    }


    public void selectMonthRet(String xpathString) {
        String monthString = findMonthString(TestData.TripDetails.returnDate);
        String currentMonth = firefoxBrowser.findElement(By.xpath(xpathString)).getText();
        if (!(currentMonth.equals(monthString))) {
            for (int i = 0; i < 12; i++) {
                String newCurrentMonth = firefoxBrowser.findElement(By.xpath(xpathString)).getText();
                if (!(newCurrentMonth.contains(monthString))) {
                    //click("button[class='next']");

                    Utility.clickElement("(.//*[@class='calendar-info-bar datepicker_clearfix'])[2]/button[2]");
                    i++;
                }
            }
        }
    }

    public String newDateFormat(String oldDate) throws ParseException {
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

    public String CalendarDateRetXpath(String date, String deptMonth) throws ParseException {
        String monthString = findMonthString(TestData.TripDetails.returnDate);
        if ((deptMonth.contains(monthString))) {
            String xpath = "(.//*[@data-id='" + newDateFormat(date) + "'])[2]";
            return xpath;
        } else {
            String xpath = ".//*[@data-id='" + newDateFormat(date) + "']";
            return xpath;
        }

    }

    public void sortFlightResultsByPrice() {
        Select s = new Select(Utility.firefoxBrowser.findElement(By.id("sort-select")));
        s.selectByValue("price");
    }
}
