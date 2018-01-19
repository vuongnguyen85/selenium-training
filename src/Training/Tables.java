package Training;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

public class Tables {
    public static void main(String[] args) throws IOException {
        WebDriver firefoxBrowser = new FirefoxDriver();

        //delete all cookies
        firefoxBrowser.manage().deleteAllCookies();

        //delete specific cookie
        firefoxBrowser.manage().deleteCookieNamed("xdfds");

        //maximise window
        firefoxBrowser.manage().window().maximize();

        firefoxBrowser.get("http://google.com");

        // take screenshot
        File src = ((TakesScreenshot)firefoxBrowser).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("//Users//vuongnguyen//dev//test.png"));


        // we can declare a web element (e.g. a table on the webpage)
        WebElement table = firefoxBrowser.findElement(By.cssSelector(""));
        // we can then use this web element to find elements within that table
        //int rowCount = table.findElements(By.cssSelector("")).size();

        // we can use div:nth-child(x) where x is the xth child div within that parent's locator
        // e.g. div:nth-child(3) will find the 3 column value for each row in a table
        int rowCount = table.findElements(By.cssSelector("cssLocator div:nth-child(x)")).size();

        // we can use rowCount-2 if we don't want the last 2 values in the table
        for (int i=0;i<rowCount-2;i++) {
            // this will return all the values in the 3rd column for each row in the table
            table.findElements(By.cssSelector("cssLocator div:nth-child(3)")).get(i);
        }

        //finding elements based on text. Here we then look at its following sibling, ending with the tagname
        System.out.println(firefoxBrowser.findElement(By.xpath("//[text()='Extras']/following-sibling::div")).getText());
    }
}
