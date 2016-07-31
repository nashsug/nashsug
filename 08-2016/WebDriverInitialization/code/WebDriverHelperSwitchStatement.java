package ?;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverHelperSwitchStatement
{
    public WebDriver initDriver(String browser) {

        WebDriver driver;

        if ("chrome".equalsIgnoreCase(browser)) {
            ClassLoader classLoader = getClass().getClassLoader();
            System.setProperty("webdriver.chrome.driver", classLoader.getResource("chromedriver.exe").getPath());
            driver = new ChromeDriver();
        }

        else if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        }

        else if ("safari".equalsIgnoreCase(browser)) {
            driver = new SafariDriver();
        }

        else {
            driver = new HtmlUnitDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }
}
