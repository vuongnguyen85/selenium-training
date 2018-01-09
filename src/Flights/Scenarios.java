package Flights;

import java.text.ParseException;

public class Scenarios {

    public void enterCityDetails(String origin, String destination) throws InterruptedException {
        SkyscannerComponents skyscanner = new SkyscannerComponents();
        skyscanner.clearOriginCityTextField();
        skyscanner.enterOriginCityInTextField();
        Thread.sleep(1000L);
        skyscanner.selectOriginCityInDropdown();
        skyscanner.enterDestinationCityInTextField();
        Thread.sleep(1000L);
        skyscanner.selectDestinationCityInDropdown();
    }

    public void selectDates(String departureDate, String returnDate) throws ParseException{
        SkyscannerComponents skyscanner = new SkyscannerComponents();
        skyscanner.clickDepartureDateTextField();
        String deptMonth = skyscanner.selectMonthForDeparture();
        skyscanner.selectDepartureDateOnCalendar();
        skyscanner.clickReturnDateTextField();
        skyscanner.selectMonthForReturnDate();
        skyscanner.selectReturnDateOnCalendar(deptMonth);
    }
}
