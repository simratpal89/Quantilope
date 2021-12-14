package Pages;

import org.openqa.selenium.WindowType;
import quantilope.script.SeleniumTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage extends SeleniumTest {

    /**
     * Open new tab and Switch
     * @param url
     */
    public void switchTabs(String url){

        // Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Open the url
        driver.get(url);
    }

    /**
     * Switch back to the parent tab
     * @param url
     */
    public void switchBackTo(String url){

        // Get all the window handles
        Set<String> handles = driver.getWindowHandles();

        // Create list object
        List<String> ls = new ArrayList<String>(handles);

        // Get Parent window
        String parentWindowId = ls.get(0);

        // Switch to Parent window
        driver.switchTo().window(parentWindowId);

        // Refresh the window
        driver.navigate().refresh();

    }
}
