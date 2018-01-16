package Flights.Expedia;

import Flights.Util.TestData;
import Flights.Util.Utility;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Expedia extends TestData {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Utility.openFirefox("http://expedia.co.uk");
        //Utility.enterURL("http://expedia.co.uk");
        Utility.firefoxBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions a = new Actions(Utility.firefoxBrowser);
        Utility.clickElement(ExpediaData.FlightTab);

        Utility.noOfTravellersExp(TripDetails.noOfAdults);

        Utility.enterText(ExpediaData.Origin,TripDetails.originCity);
        //a.moveToElement(firefoxBrowser.findElement(By.cssSelector("#flight-origin-hp-flight"))).click().keyDown(Keys.SHIFT).sendKeys("t").build().perform(); //click into box and sendkeys while holding shift

        //a.doubleClick(findByXpath(ExpediaData.firstOptionDeparture));
        Utility.clickElement(ExpediaData.firstOptionDeparture);
        Utility.pressEnter(ExpediaData.firstOptionDeparture);

        Utility.enterText(ExpediaData.Destination,TripDetails.destinationCity);

        //Thread.sleep(1000L);

        //a.doubleClick(findByXpath(ExpediaData.firstOptionDestination)); //double click within an element
        //a.moveToElement(findByXpath(ExpediaData.firstOptionDestination)).build().perform(); // hover over an element
        Utility.clickElement(ExpediaData.firstOptionDestination);
        Utility.pressEnter(ExpediaData.firstOptionDestination); //pressing enter within an element

        Utility.enterText(ExpediaData.DepatureDate,TripDetails.departureDate);

        Utility.clearText(TestData.ExpediaData.ReturnDate);
        Utility.enterText(ExpediaData.ReturnDate,TripDetails.returnDate);
        Utility.clickElement(ExpediaData.CloseCalendar);
        Utility.clickElement(ExpediaData.SubmitButton);

        //WebDriverWait d=new WebDriverWait(Utility.firefoxBrowser,25); //explicit wait
        //d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is clickable using locator
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is visible using locator
        //Utility.clickElement("#airlineToggleLink");
        //Utility.clickElement(ExpediaData.EmiratesFilter);
        //Utility.clickElement("#Qatar-Airways-flights-checkbox");

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " milliseconds taken to complete script");

        }
}
