package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver firefoxBrowser = new FirefoxDriver();
        firefoxBrowser.get("http://expedia.co.uk");
        firefoxBrowser.findElement(By.cssSelector("#tab-flight-tab-hp")).click();

        Select s = new Select(firefoxBrowser.findElement(By.id("flight-adults-hp-flight")));
        //s.selectByValue("4"); // selects value where value = '4'
        //s.selectByIndex(3); //select 4th value in the dropdown, remember index starts from 0
        //s.selectByVisibleText("1"); // selects by text displayed in the dropdown


        firefoxBrowser.findElement(By.cssSelector("#flight-origin-hp-flight")).sendKeys("l");
        //ExpectedConditions.elementToBeClickable()

        Thread.sleep(1000L); //wait for 1 second

        firefoxBrowser.findElement(By.xpath(".//*[@id='aria-option-0']/parent::li")).click();
        firefoxBrowser.findElement(By.xpath(".//*[@id='aria-option-0']/parent::li")).click();

        firefoxBrowser.findElement(By.cssSelector("#flight-destination-hp-flight")).sendKeys("hkg");

        Thread.sleep(1000L);

        firefoxBrowser.findElement(By.xpath("(.//*[@id='aria-option-0'])[1]/parent::li")).click();
        firefoxBrowser.findElement(By.xpath("(.//*[@id='aria-option-0'])[1]/parent::li")).click();


        firefoxBrowser.findElement(By.cssSelector("#flight-departing-hp-flight")).sendKeys("06/07/2018");
        firefoxBrowser.findElement(By.cssSelector("#flight-returning-hp-flight")).clear();
        firefoxBrowser.findElement(By.cssSelector("#flight-returning-hp-flight")).sendKeys("22/07/2018");

        firefoxBrowser.findElement(By.cssSelector("[class='datepicker-close-btn close btn-text']")).click();

        firefoxBrowser.findElement(By.cssSelector("[class='btn-primary btn-action gcw-submit']")).click();

        Thread.sleep(3000L);

        firefoxBrowser.findElement(By.cssSelector("#airlineRowContainer_EK")).click();

        //if more than one instance of attribute, can use the following for xpath: "(//a[@value='DEL'])[2])" - this will give the 2nd incidence of when this value is found on the website (e.g. return destination)

        //use isSelected after locating element to find out if checkbox is checked or not

        //findElements(By.xpath("")).size(); //give the number of elements with the same attribute values specified

        //firefoxBrowser.findElements(By.xpath("")).get(2).click(); // this will click on the 3rd incident of element with the same xpath

        //firefoxBrowser.switchTo().alert().accept(); // for clicking on positive outcome on java popup (i.e. no html present), use dismiss for negative options (e.g. no, cancel)

        //firefoxBrowser.findElement(By.xpath("")).isDisplayed(); //boolean to check whether an element is visible. Useful for elements whose visibility is dependent on another factor.
        // this only works if present in the code but hidden. Won't work if not present in the code at all.
        // for something that is not in code, use findElements and use size method, if size = 0, this is sufficient that element is no longer present in the page




    }
}
