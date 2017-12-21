import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise {
    public static void main(String[] args) {
        WebDriver firefoxBrowser = new FirefoxDriver();
        //WebDriver chromeBrowser = new ChromeDriver();

        firefoxBrowser.get("https://rediff.com");
        firefoxBrowser.findElement(By.cssSelector("[title*='Sign in']")).click();
        firefoxBrowser.findElement(By.xpath("//input[contains(@id,'log')]")).sendKeys("test");
        firefoxBrowser.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("password");
        firefoxBrowser.findElement(By.cssSelector("[name*='proceed']")).click();

    }
}
