package Flights.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
    public static long startTime;
    public static WebDriver firefoxBrowser = new FirefoxDriver();

    public void calculateScriptDuration() {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " milliseconds taken to complete script");
    }

    public static void openFirefoxBrowser(String url) {
        startTime = System.currentTimeMillis();
        firefoxBrowser.get(url);
    }

    public static WebElement findElement(String path) {
        if (path.contains(".//")) {
            return firefoxBrowser.findElement(By.xpath(path));
        } else {
            return firefoxBrowser.findElement(By.cssSelector(path));
        }
    }

    public static void clickElement(String path) {
        findElement(path).click();
    }

    public static void pressEnter(String path) {
        findElement(path).sendKeys(Keys.ENTER);
    }

    public static void clearText(String path) {
        findElement(path).clear();
    }

    public static void enterText(String path, String textEntry) {
        findElement(path).sendKeys(textEntry);
    }

    public static void noOfTravellersExp(int number) {
        Select s = new Select(firefoxBrowser.findElement(By.id("flight-adults-hp-flight")));
        String s1 = Integer.toString(number);
        s.selectByValue(s1);
    }
}
