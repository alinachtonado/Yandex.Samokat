import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageModel {
    private final WebDriver driver;

    private final By orderTopButton = By.xpath("(.//button[text()=\"Заказать\"])[1]");

    private final By orderBottomButton = By.xpath("(.//button[text()=\"Заказать\"])[2]");

    // локатор кнопки Да все привыкли
    private final By consentButtonLocator = By.xpath(".//button[text()=\"да все привыкли\"]");

    //конструктор класса
    public HomePageModel(WebDriver driver){
        this.driver = driver;
    }

    public void clickQuestion(int number){
        By questionLocator = By.id("accordion__heading-" + number);
        WebElement question = driver.findElement(questionLocator);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void waitForAnswerShown(int number, String expectedText){
        By answerLocator = By.id("accordion__panel-" + number);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        WebElement answer = driver.findElement(answerLocator);
        String text = answer.getText();
        Assert.assertEquals(text, expectedText);
    }

    public void clickOrderButton(boolean bottomButton){
        driver.findElement(consentButtonLocator).click();
        if (bottomButton){
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(orderBottomButton))
                    .click();
        }else{
            driver.findElement(orderTopButton).click();
        }
    }
}
