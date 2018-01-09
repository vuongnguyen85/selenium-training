package Flights;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Skyscanner {

    public static void main(String[] args) throws InterruptedException, ParseException {
        long startTime = System.currentTimeMillis();

        SkyscannerComponents skyscanner = new SkyscannerComponents();
        Scenarios scenario = new Scenarios();

        skyscanner.openBrowser();
        skyscanner.firefoxBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait d = new WebDriverWait(Utility.firefoxBrowser, 30); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector(TestData.SkyScannerData.cssOrigin)));
        //Actions a = new Actions(firefoxBrowser);

        scenario.enterCityDetails(TestData.TripDetails.originCity,TestData.TripDetails.destinationCity);
        scenario.selectDates(TestData.TripDetails.departureDate, TestData.TripDetails.returnDate);

        skyscanner.clickSearch();

        Thread.sleep(7000L);
        d.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='progress-spinner hot-spinner'")));

        skyscanner.sortFlightResultsByPrice();

        skyscanner.clearAllAirlineFilters();
        Thread.sleep(2000l);
        skyscanner.filterByAirline("Emirates");
        Thread.sleep(2000l);
        skyscanner.filterByAirline("Qatar");

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " milliseconds taken to complete script");


    }


}
