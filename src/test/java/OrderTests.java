import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderTests {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void topButtonOrderTest(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickOrderButton(false);

        OrderPageModel orderPageModel = new OrderPageModel(driver);
        orderPageModel.setFirstForm("Порфирий", "Петрович", "Москва 1", "Чертан", "+9991234567");
        orderPageModel.nextClick();

        orderPageModel.setSecondForm(2, false, "Привезите, пожалуйста!");
        orderPageModel.clickOrderButton();

        orderPageModel.clickConfirmButton();

        orderPageModel.checkSuccessMessage();
    }

    @Test
    public void bottomButtonOrderTest(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickOrderButton(true);

        OrderPageModel orderPageModel = new OrderPageModel(driver);
        orderPageModel.setFirstForm("Имя", "Фамилия", "Москва 2", "Черкиз", "+1231255516");
        orderPageModel.nextClick();

        orderPageModel.setSecondForm(3, true, "");
        orderPageModel.clickOrderButton();

        orderPageModel.clickConfirmButton();

        orderPageModel.checkSuccessMessage();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
