package Flights.Expedia;

import Flights.Util.Utility;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import static Flights.Util.TestData.ExpediaData.*;
import static Flights.Util.TestData.TripDetails.*;

public class Expedia {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Utility.openFirefox("http://expedia.co.uk");
        Utility.firefoxBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions a = new Actions(Utility.firefoxBrowser);
        Utility.clickElement(FlightTab);

        Utility.noOfTravellersExp(noOfAdults);

        Utility.enterText(Origin,originCity);
        //a.moveToElement(firefoxBrowser.findElement(By.cssSelector("#flight-origin-hp-flight"))).click().keyDown(Keys.SHIFT).sendKeys("t").build().perform(); //click into box and sendkeys while holding shift

        //a.doubleClick(findByXpath(ExpediaData.firstOptionDeparture));
        Utility.clickElement(firstOptionDeparture);
        Utility.pressEnter(firstOptionDeparture);

        Utility.enterText(Destination,destinationCity);

        //Thread.sleep(1000L);

        //a.doubleClick(findByXpath(ExpediaData.firstOptionDestination)); //double click within an element
        //a.moveToElement(findByXpath(ExpediaData.firstOptionDestination)).build().perform(); // hover over an element
        Utility.clickElement(firstOptionDestination);
        Utility.pressEnter(firstOptionDestination); //pressing enter within an element

        Utility.enterText(DepatureDate,departureDate);

        Utility.clearText(ReturnDate);
        Utility.enterText(ReturnDate,returnDate);
        Utility.clickElement(CloseCalendar);
        Utility.clickElement(SubmitButton);

        //WebDriverWait d=new WebDriverWait(Utility.firefoxBrowser,25); //explicit wait
        //d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is clickable using locator
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is visible using locator
        //Utility.clickElement("#airlineToggleLink");
        //Utility.clickElement(ExpediaData.EmiratesFilter);
        //Utility.clickElement("#Qatar-Airways-flights-checkbox");

        long endTime   = System.currentTimeMillis();
        long totalTime = (endTime - startTime)/1000;
        System.out.println(totalTime + " seconds taken to complete script");

        }
}
