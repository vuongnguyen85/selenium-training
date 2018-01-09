package Flights;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
    public static WebDriver firefoxBrowser = new FirefoxDriver();

    public static void loadFirefox(String url) {
        firefoxBrowser.get(url);
    }

    public static WebElement findByCSS(String cssString) {
        return firefoxBrowser.findElement(By.cssSelector(cssString));
    }

    public static void clickCss(String cssString) {
        findByCSS(cssString).click();
    }

    public static void enterText(String cssString, String textEntry) {
        findByCSS(cssString).sendKeys(textEntry);
    }

    public static void clearTextOrigin(String cssString) {
        findByCSS(cssString).clear();
    }


    public static void noOfTravellersExp(int number) {
        Select s = new Select(firefoxBrowser.findElement(By.id("flight-adults-hp-flight")));
        String s1 = Integer.toString(number);
        s.selectByValue(s1);
    }

    private static WebElement findByXpath(String xpathString) {
        return firefoxBrowser.findElement(By.xpath(xpathString));
    }

    public static void clickXpath(String xpath) {
        findByXpath(xpath).click();
    }

    public static void pressEnterXpath(String xpath) {
        findByXpath(xpath).sendKeys(Keys.ENTER);
    }
}
