package Flights;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class Expedia extends TestData {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Utility.openFirefoxBrowser("http://expedia.co.uk");
        Utility.firefoxBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions a = new Actions(Utility.firefoxBrowser);
        Utility.clickElement(ExpediaData.cssFlightTab);

        Utility.noOfTravellersExp(TripDetails.noOfAdults);

        Utility.enterText(ExpediaData.cssOrigin,TripDetails.originCity);
        //a.moveToElement(firefoxBrowser.findElement(By.cssSelector("#flight-origin-hp-flight"))).click().keyDown(Keys.SHIFT).sendKeys("t").build().perform(); //click into box and sendkeys while holding shift

        //a.doubleClick(findByXpath(ExpediaData.xPathfirstOptionDeparture));
        Utility.clickElement(ExpediaData.xPathfirstOptionDeparture);
        Utility.pressEnter(ExpediaData.xPathfirstOptionDeparture);

        Utility.enterText(ExpediaData.cssDestination,TripDetails.destinationCity);

        //Thread.sleep(1000L);

        //a.doubleClick(findByXpath(ExpediaData.xPathfirstOptionDestination)); //double click within an element
        //a.moveToElement(findByXpath(ExpediaData.xPathfirstOptionDestination)).build().perform(); // hover over an element
        Utility.clickElement(ExpediaData.xPathfirstOptionDestination);
        Utility.pressEnter(ExpediaData.xPathfirstOptionDestination); //pressing enter within an element

        Utility.enterText(ExpediaData.cssDepatureDate,TripDetails.departureDate);

        Utility.clearText(TestData.ExpediaData.cssReturnDate);
        Utility.enterText(ExpediaData.cssReturnDate,TripDetails.returnDate);
        Utility.clickElement(ExpediaData.cssCloseDates);
        Utility.clickElement(ExpediaData.cssSubmit);

        WebDriverWait d=new WebDriverWait(Utility.firefoxBrowser,25); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is clickable using locator
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is visible using locator
        Utility.clickElement("#airlineToggleLink");
        Utility.clickElement(ExpediaData.cssEmiratesFilter);
        Utility.clickElement("#Qatar-Airways-flights-checkbox");

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " milliseconds taken to complete script");

        }
}
