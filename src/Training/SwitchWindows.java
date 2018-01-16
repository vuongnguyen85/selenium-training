package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver firefoxBrowser = new FirefoxDriver();

        firefoxBrowser.get("https://accounts.google.com/signup");
        firefoxBrowser.findElement(By.xpath("id(\"wrapper\")/div[2]/div[1]/div[1]/p[1]/a[1]")).click();
        System.out.println(firefoxBrowser.getTitle());

        Set<String> ids=firefoxBrowser.getWindowHandles();

        Iterator<String> it=ids.iterator();
        String parentid=it.next();
        String childid=it.next();

        firefoxBrowser.switchTo().window(childid); //now child window is in focus
        Thread.sleep(1000l);
        System.out.println(firefoxBrowser.getTitle()); //will now get title of any child windows opened


        firefoxBrowser.switchTo().frame(firefoxBrowser.findElement(By.cssSelector("xx"))); // use to target iframes within a webpage

        Actions a = new Actions(firefoxBrowser);

        WebElement source = firefoxBrowser.findElement(By.id("a"));
        WebElement target = firefoxBrowser.findElement(By.id("b"));

        a.dragAndDrop(source,target).build().perform(); // can then use drag and drop within the iframe

        firefoxBrowser.switchTo().defaultContent(); //remember to use to switch back to main window

        //total number of links on a page
        System.out.println("Total number of links on a page is " + firefoxBrowser.findElements(By.tagName("a")).size());

        //total number of links on a footer
        WebElement footer = firefoxBrowser.findElement(By.xpath("some id"));
        System.out.println("Total number of links on the footer is " + footer.findElements(By.tagName("a")).size());

        for (int i=0;i<footer.findElements(By.tagName("a")).size();i++) {
            // get the name of the link iteratively
            //System.out.println(footer.findElements(By.tagName("a")).get(i).getText());

            if (footer.findElements(By.tagName("a")).get(i).getText().contains("some text")) {
                // this will find a link titled "some text" and then click on this link
                footer.findElements(By.tagName("a")).get(i).click();
            }

            //dynamic calendar
            // can use findelements method and select a common classname and iterate through using a for loop
            // use if .equals("day") and get(i).click() only when if statement is true


        }
    }
}
