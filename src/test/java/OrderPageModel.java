import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageModel {
    private final WebDriver driver;

    //локатор поля Имя
    private final By firstnameLocator = By.xpath(".//input[@placeholder='* Имя']");

    //локатор поля Фамилия
    private final By lastnameLocator = By.xpath(".//input[@placeholder='* Фамилия']");

    //локатор поля Адрес
    private final By addressLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //локатор поля Метро
    private final By metroLocator = By.xpath(".//input[@placeholder='* Станция метро']");

    // локатор элемента метро
    private final By metroElementLocator = By.cssSelector(".select-search__row:first-child button");

    //локатор поля Телефон
    private final By phoneLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор кнопки Да все привыкли
    private final By consentButtonLocator = By.xpath(".//button[text()=\"да все привыкли\"]");

    //локатор кнопки Далее
    private final By nextButtonLocator = By.xpath(".//button[text()=\"Далее\"]");

    //локатор времени
    private final By timeLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //локатор сегодняшнего дня
    private final By todayLocator = By.cssSelector(".react-datepicker__day.react-datepicker__day--today");

    //локатор длительности
    private final By durationLocator = By.cssSelector(".Dropdown-control");

    //локатор длительности - 1 день
    private final By oneDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(1)");

    //локатор длительности - 2 день
    private final By twoDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(2)");

    //локатор длительности - 3 день
    private final By threeDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(3)");

    //локатор длительности - 4 день
    private final By fourDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(4)");

    //локатор длительности - 5 день
    private final By fiveDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(5)");

    //локатор длительности - 6 день
    private final By sixDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(6)");

    //локатор длительности - 7 день
    private final By sevenDayLocator = By.cssSelector(".Dropdown-menu .Dropdown-option:nth-child(7)");

    //локатор черного цвета
    private final By blackColorLocator = By.cssSelector("#black");

    //локатор серого цвета
    private final By greyColorLocator = By.cssSelector("#grey");

    //локатор комментария
    private final By commentLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //локатор кнопки заказа
    private final By orderButtonLocator = By.xpath("(.//button[text()=\"Заказать\"])[2]");

    //локатор кнопки подтверждения
    private final By confirmButtonLocator = By.xpath(".//button[text()=\"Да\"]");

    // локатор сообщения об успешном оформлении заказа
    private final By successMessageLocator = By.xpath(".//div[contains(text(),\"Заказ оформлен\")]");

    public OrderPageModel(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstForm(String firstname, String lastname, String address, String metro, String phone) {
        driver.findElement(firstnameLocator).sendKeys(firstname);
        driver.findElement(lastnameLocator).sendKeys(lastname);
        driver.findElement(addressLocator).sendKeys(address);
        driver.findElement(metroLocator).sendKeys(metro);

        WebElement metroElement = driver.findElement(metroElementLocator);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(metroElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", metroElement);
        metroElement.click();

        driver.findElement(phoneLocator).sendKeys(phone);
    }

    public void nextClick(){
        driver.findElement(nextButtonLocator).click();
    }

    public void setSecondForm(int durationDays, boolean isBlack, String comment){
        driver.findElement(timeLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(todayLocator))
                .click();

        driver.findElement(durationLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(getDurationLocator(durationDays)))
                .click();

        if (isBlack){
            driver.findElement(blackColorLocator).click();
        }else{
            driver.findElement(greyColorLocator).click();
        }

        driver.findElement(commentLocator).sendKeys(comment);
    }

    public void clickOrderButton(){
        driver.findElement(orderButtonLocator).click();
    }

    public void clickConfirmButton(){
        driver.findElement(confirmButtonLocator).click();
    }

    public void checkSuccessMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions.elementToBeClickable(successMessageLocator));
    }

    private By getDurationLocator(int durationDays){
        if (durationDays == 1){
            return oneDayLocator;
        }

        if (durationDays == 2){
            return twoDayLocator;
        }

        if (durationDays == 3){
            return threeDayLocator;
        }

        if (durationDays == 4){
            return fourDayLocator;
        }

        if (durationDays == 5){
            return fiveDayLocator;
        }

        if (durationDays == 6){
            return sixDayLocator;
        }

        if (durationDays == 7){
            return sevenDayLocator;
        }

        return null;
    }
}
