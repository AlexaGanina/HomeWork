import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseRunner {

    public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
    public WebDriver driver;
    public String browserName = System.getProperty("browser");
    public String baseUrl;


    @BeforeClass
    public void setUp(){
       driver = tl.get();
       driver.manage().window().maximize();
       baseUrl = "https://www.tinkoff.ru/";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       Runtime.getRuntime().addShutdownHook(new Thread(() -> {
           driver.quit();
           driver = null;
       }));
    }

}
