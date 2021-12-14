package quantilope.script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class SeleniumTest
{
    protected static WebDriver driver;

    /**
     * This method will open the browser and Application before Test
     */
    @BeforeTest(alwaysRun = true)
    public void launchBrowser() {

    	// Webdriver Manager will set up the Chrome browser
    	WebDriverManager.chromedriver().setup();
    	
        // Initialize the driver
        driver = new ChromeDriver();
        
        // Open the application
        driver.get("https://app.quantilope.com/share/ELxib6zdYkwCgYsCD?type=dashboard");
        
        // Implement implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Maximize the window
        driver.manage().window().maximize();

    }
    
    /**
     * This method will quit the browser after test
     */
    @AfterTest(alwaysRun = true)
    public void tearDown() {
    	if(driver != null)
    	driver.quit();
    }
}
