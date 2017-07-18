package testtask.lv.ss.Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * parent for all test classes
 */

public abstract class SslvTest {
    public static WebDriver driver;
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ss.lv");
    }

    @After
    public void close(){
        driver.close();
    }

}