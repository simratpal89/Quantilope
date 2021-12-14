package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SurveyPage extends BasePage {

    /**
     * Click Get start button
     */
    public void clickGetStartedButton(){
        WebElement getStartedButton = driver.findElement(By.id("startSurvey"));
        getStartedButton.click();
    }

    /**
     * Select answer for question-1
     * @param buttonName
     */
    public void clickRadioButtonQ1(String buttonName) {
        WebElement radioButtonElement = driver.findElement(By.xpath("//p[text()='"+buttonName+"']/../../../../..//div[@class='qRadio']"));
        radioButtonElement.click();
    }

    /**
     * Click next button
     */
    public void clickNextButton() {
        WebElement nextButtonElement = driver.findElement(By.id("nextPage"));
        nextButtonElement.click();
    }

    /**
     * Set engineer value for question-2
     * @param engineerNumber
     */
    public void setEngineerValueQ2(String engineerNumber){
        WebElement textFieldValue = driver.findElement(By.xpath("//input[@placeholder='Type in your value']"));
        textFieldValue.sendKeys(engineerNumber);
    }

    /**
     * Select option for question-3
     * @param optionNumber
     */
    public void clickOptionQuestionQ3(String optionNumber) {
        WebElement radioButtonElement = driver.findElement(By.xpath("//p[contains(text(),'"+optionNumber+"')]/../../../..//div[@class='matrixBody']//div[@class='qRadio']/../../div["+optionNumber+"]//div"));
        radioButtonElement.click();
    }

    /**
     * Fill survey with different valid values
     * @param color
     * @param engineerNumber
     * @param range
     */
    public void fillSurvey(String color, String engineerNumber, String range){

        // Click start button
        clickGetStartedButton();

        // Select radio button for question 1
        clickRadioButtonQ1(color);

        // Click next button
        clickNextButton();

        // Set Engineers value for question 2
        setEngineerValueQ2(engineerNumber);

        // Click next button
        clickNextButton();

        // Select range for question 3
        clickOptionQuestionQ3(range);

        // Click next button
        clickNextButton();

    }
}
