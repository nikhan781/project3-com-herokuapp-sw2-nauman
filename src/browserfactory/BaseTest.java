package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static String browser;

    public void browserSetup(String baseurl, String browser) {
        // 1. Using Switch statement to set up and select between browsers
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser selection");
        }
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //driver = new ChromeDriver();

        //Opening Url
        driver.get(baseurl);

        //Maximising the window upon opening browser
        driver.manage().window().maximize();

        //Setting timeout to give WebDriver to load the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    //Method to close the browser
    public void closingTheBrowser() {

        driver.quit();
    }
}
