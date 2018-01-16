package AirBNB;

import org.openqa.selenium.By;

import static AirBNB.Util.Utility.findElement;
import static AirBNB.Util.Utility.firefoxBrowser;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        firefoxBrowser.get("http://airbnb.co.uk");
        Thread.sleep(2000l);
        findElement(".//*[@class='_k3jto05']").sendKeys("cornwall");
    }
}
