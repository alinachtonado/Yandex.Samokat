import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTests {
    private WebDriver driver;

    private final boolean bottomButton;

    public OrderTests(boolean bottomButton) {
        this.bottomButton = bottomButton;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { true }, { false }
        });
    }

    @Test
    public void orderFromTest(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickOrderButton(bottomButton);

        OrderPageModel orderPageModel = new OrderPageModel(driver);
        orderPageModel.setFirstForm("Порфирий", "Петрович", "Москва 1", "Чертан", "+9991234567");
        orderPageModel.nextClick();

        orderPageModel.setSecondForm(2, false, "Привезите, пожалуйста!");
        orderPageModel.clickOrderButton();

        orderPageModel.clickConfirmButton();

        orderPageModel.checkSuccessMessage();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
