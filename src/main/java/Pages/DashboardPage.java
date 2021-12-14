package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class DashboardPage extends BasePage {

    /**
     * Get bar value for specific horizontal bar
     * @param value
     * @return tool tip text for specific bar
     * @throws InterruptedException
     */
    public String getBarValue(int value) throws InterruptedException {

        String tooltipText = null;
        List<WebElement> horizontalBars = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series highcharts-series-0 highcharts-bar-series highcharts-tracker']//*[name()='rect']"));

        Actions actions = new Actions(driver);
        for (WebElement e : horizontalBars) {
            actions.moveToElement(e).perform();
            Thread.sleep(1000);

            if(value == horizontalBars.indexOf(e)) {
                String text = getTooltipText(value);
                tooltipText = StringUtils.substringAfter(text, ":");
            }

        }
        return tooltipText;
    }

    /**
     * Get tool tip text
     * @param number
     * @return tool tip text
     */
    public String getTooltipText(int number){
        WebElement toolTipText = driver.findElement(By.xpath("//p[text()='q3 Personal Cheese opinions']/../../..//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-" + number + "']//*[name()='text']"));
        return toolTipText.getText();
    }

}
