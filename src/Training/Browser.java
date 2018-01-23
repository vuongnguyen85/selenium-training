package Training;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class Browser {

    public static WebDriver firefoxBrowser;

    public static WebDriver openFirefox(String url) {
        System.setProperty("webdriver.gecko.driver", "//Users//vuongnguyen//dev//WebDriver//geckodriver");
        firefoxBrowser = new FirefoxDriver();
        firefoxBrowser.get(url);
        return firefoxBrowser;
    }

    public static void main(String[] args) throws InterruptedException {


        //WebDriver chromeBrowser = new ChromeDriver();

        openFirefox("https://application.adthena.com/");


        // CLASS NAME
        //firefoxBrowser.findElement(By.className("inputtext")).sendKeys("vuong_nguyen7@hotmail.com");
        // this is also find, we can't use className when there is a space

        // ID
        firefoxBrowser.findElement(By.id("username")).sendKeys("vuong.nguyen@adthena.com");
        firefoxBrowser.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div/div/div/div/input")).sendKeys("vuong");

        // LINK TEXT
        //firefoxBrowser.findElement(By.linkText("Forgotten account?")).click();
        // finding linked text on the page, us text between <a> </a>

        // XPATH
        Thread.sleep(3000l);
        firefoxBrowser.findElement(By.cssSelector("[class='btn btn-highlight']")).click();
        //inspect element, right click and select copy > xpath
        //may need to change double quote to single quote due to syntax error in java
        // (firefox) any xpath which starts with html is not reliable and shouldn't be used, check in chrome

        // CSS SELECTOR
        //firefoxBrowser.findElement(By.cssSelector("#u_0_a")).click();
        //inspect element, right click and select copy > CSS selector (firefox only). There is no direct way to get this in chrome, you will find it in the tool bar
        // this may not be unique and can change with each load

        // Failing to login



        //firefoxBrowser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //System.out.println(firefoxBrowser.getTitle());
        //System.out.println(firefoxBrowser.getCurrentUrl());

        //firefoxBrowser.close();
    }

    @Test
    public void FailedLogin() throws IOException, InterruptedException {

        openFirefox("https://application.adthena.com/");
        firefoxBrowser.findElement(By.id("username")).sendKeys("vuong.nguyen@adthena.com");
        firefoxBrowser.findElement(By.cssSelector("[name='password']")).sendKeys("vuong");
        firefoxBrowser.findElement(By.cssSelector("[class='btn btn-highlight']")).click();

        Assert.assertEquals(firefoxBrowser.findElement(By.id("js-pswd")).getText(),"Username or password cannot be found. Please try again.");

        Thread.sleep(500l);
        File src = ((TakesScreenshot)firefoxBrowser).getScreenshotAs(OutputType.FILE);
        copyFile(src,new File("//Users//vuongnguyen//dev//FailedLogin.png"));

        firefoxBrowser.quit();
        }

    @Test
    public void SuccessfulLogin() throws IOException, InterruptedException {

        openFirefox("https://application.adthena.com/");
        firefoxBrowser.findElement(By.id("username")).sendKeys("vuong.nguyen@adthena.com");
        firefoxBrowser.findElement(By.cssSelector("[name='password']")).sendKeys("vuong2410");
        //firefoxBrowser.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div/div/div/div/input")).sendKeys("vuong2410");
        firefoxBrowser.findElement(By.cssSelector("[class='btn btn-highlight']")).click();

        Thread.sleep(5000l);
        Assert.assertEquals(firefoxBrowser.findElement(By.cssSelector("[class='page-header clearfix']")).getText(),"Summary Dashboard");

        File src = ((TakesScreenshot)firefoxBrowser).getScreenshotAs(OutputType.FILE);
        copyFile(src,new File("//Users//vuongnguyen//dev//SuccessfulLogin.png"));

        firefoxBrowser.quit();
    }
}

