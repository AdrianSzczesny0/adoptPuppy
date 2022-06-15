package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase
{

    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;

    public TestBase()
    {

        try
        {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/Config/config.properties"));
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void Initialization()
    {
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/WebDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else
        if(browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver,20);

    }
    public int getRandomIntInRange(int from){
        Random random = new Random();
        return random.nextInt(from);
    }

}
