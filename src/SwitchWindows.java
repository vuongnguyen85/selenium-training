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
    }
}
