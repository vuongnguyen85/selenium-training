import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    }
}
