package Flights;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class Expedia extends TestData {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Utility.loadFirefox("http://expedia.co.uk");
        Utility.firefoxBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions a = new Actions(Utility.firefoxBrowser);
        Utility.clickCss(ExpediaData.cssFlightTab);

        Utility.noOfTravellersExp(2);

        Utility.enterText(ExpediaData.cssOrigin,TripDetails.originCity);
        //a.moveToElement(firefoxBrowser.findElement(By.cssSelector("#flight-origin-hp-flight"))).click().keyDown(Keys.SHIFT).sendKeys("t").build().perform(); //click into box and sendkeys while holding shift

        //Thread.sleep(1000L); //wait for 1 second

        //a.doubleClick(findByXpath(ExpediaData.xPathfirstOptionDeparture));
        Utility.clickXpath(ExpediaData.xPathfirstOptionDeparture);
        Utility.pressEnterXpath(ExpediaData.xPathfirstOptionDeparture);

        Utility.enterText(ExpediaData.cssDestination,TripDetails.destinationCity);

        //Thread.sleep(1000L);

        //a.doubleClick(findByXpath(ExpediaData.xPathfirstOptionDestination)); //double click within an element
        //a.moveToElement(findByXpath(ExpediaData.xPathfirstOptionDestination)).build().perform(); // hover over an element
        Utility.clickXpath(ExpediaData.xPathfirstOptionDestination);
        Utility.pressEnterXpath(ExpediaData.xPathfirstOptionDestination); //pressing enter within an element

        Utility.enterText(ExpediaData.cssDepatureDate,TripDetails.departureDate);

        Utility.clearTextOrigin(TestData.ExpediaData.cssReturnDate);
        Utility.enterText(ExpediaData.cssReturnDate,TripDetails.returnDate);
        Utility.clickCss(ExpediaData.cssCloseDates);
        Utility.clickCss(ExpediaData.cssSubmit);

        WebDriverWait d=new WebDriverWait(Utility.firefoxBrowser,15); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is clickable using locator
        //d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#airlineRowContainer_EK"))); //waiting until the element is visible using locator
        Utility.clickCss("#airlineToggleLink");
        Thread.sleep(2000l);
        Utility.clickCss(ExpediaData.cssEmiratesFilter);
        Thread.sleep(2000l);
        Utility.clickCss("#Qatar-Airways-flights-checkbox");

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " milliseconds taken to complete script");

        }






}
