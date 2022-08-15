import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageModel {
    private final WebDriver driver;

    //локатор вопроса 1
    private final By question1 = By.id("accordion__heading-0");
    //локатор ответа 1
    private final By answer1 = By.id("accordion__panel-0");

    //локатор вопроса 1
    private final By question2 = By.id("accordion__heading-1");
    //локатор ответа 1
    private final By answer2 = By.id("accordion__panel-1");

    //локатор вопроса 2
    private final By question3 = By.id("accordion__heading-2");
    //локатор ответа 2
    private final By answer3 = By.id("accordion__panel-2");

    //локатор вопроса 2
    private final By question4 = By.id("accordion__heading-3");
    //локатор ответа 2
    private final By answer4 = By.id("accordion__panel-3");

    //локатор вопроса 2
    private final By question5 = By.id("accordion__heading-4");
    //локатор ответа 2
    private final By answer5 = By.id("accordion__panel-4");

    //локатор вопроса 2
    private final By question6 = By.id("accordion__heading-5");
    //локатор ответа 2
    private final By answer6 = By.id("accordion__panel-5");

    //локатор вопроса 2
    private final By question7 = By.id("accordion__heading-6");
    //локатор ответа 2
    private final By answer7 = By.id("accordion__panel-6");

    //локатор вопроса 2
    private final By question8 = By.id("accordion__heading-7");
    //локатор ответа 2
    private final By answer8 = By.id("accordion__panel-7");

    private final By orderTopButton = By.xpath("(.//button[text()=\"Заказать\"])[1]");

    private final By orderBottomButton = By.xpath("(.//button[text()=\"Заказать\"])[2]");

    //конструктор класса
    public HomePageModel(WebDriver driver){
        this.driver = driver;
    }

    public void clickQuestion1(){
        WebElement question = driver.findElement(question1);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion2(){
        WebElement question = driver.findElement(question2);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion3(){
        WebElement question = driver.findElement(question3);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion4(){
        WebElement question = driver.findElement(question4);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion5(){
        WebElement question = driver.findElement(question5);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion6(){
        WebElement question = driver.findElement(question6);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion7(){
        WebElement question = driver.findElement(question7);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void clickQuestion8(){
        WebElement question = driver.findElement(question8);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public void waitForAnswer1Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer1));
    }

    public void waitForAnswer2Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer2));
    }

    public void waitForAnswer3Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer3));
    }

    public void waitForAnswer4Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer4));
    }

    public void waitForAnswer5Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer5));
    }

    public void waitForAnswer6Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer6));
    }

    public void waitForAnswer7Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer7));
    }

    public void waitForAnswer8Shown(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer8));
    }

    public void clickOrderTopButton(){
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton(){
        driver.findElement(orderBottomButton).click();
    }
}
