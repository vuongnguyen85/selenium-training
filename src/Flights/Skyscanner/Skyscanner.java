package Flights.Skyscanner;

import Flights.Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static Flights.Util.TestData.SkyScannerData.*;
import static Flights.Util.TestData.TripDetails.*;
import static Flights.Util.Utility.*;

public class Skyscanner {

    public static void main(String[] args) {

    }

    public void runOnSkyscanner() throws InterruptedException, ParseException{
        SkyscannerComponents skyscanner = new SkyscannerComponents();
        Scenarios scenario = new Scenarios();

        openFirefox("http://skyscanner.net");

        firefoxBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait d = new WebDriverWait(firefoxBrowser, 60); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OriginCityField)));

        scenario.enterCityDetails(originCity,destinationCity);
        scenario.selectDates(departureDate, returnDate);

        skyscanner.clickSearch();
        d.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='progress-spinner hot-spinner'")));
        skyscanner.sortFlightResultsByPrice();
        calculateScriptDuration();
    }
}
