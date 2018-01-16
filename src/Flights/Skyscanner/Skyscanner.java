package Flights.Skyscanner;

import Flights.Util.TestData;
import Flights.Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Skyscanner {

    public static void main(String[] args) {

    }

    public void runOnSkyscanner() throws InterruptedException, ParseException{
        SkyscannerComponents skyscanner = new SkyscannerComponents();
        Scenarios scenario = new Scenarios();

        skyscanner.openFirefox();
        skyscanner.enterURL("http://skyscanner.net");

        skyscanner.firefoxBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait d = new WebDriverWait(Utility.firefoxBrowser, 60); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector(TestData.SkyScannerData.OriginCityField)));

        scenario.enterCityDetails(TestData.TripDetails.originCity,TestData.TripDetails.destinationCity);
        scenario.selectDates(TestData.TripDetails.departureDate, TestData.TripDetails.returnDate);

        skyscanner.clickSearch();
        d.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='progress-spinner hot-spinner'")));
        skyscanner.sortFlightResultsByPrice();
        skyscanner.calculateScriptDuration();
    }
}
