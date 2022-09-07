import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageQuestionsTests {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void question1Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(0);
        homePageModel.waitForAnswerShown(0);
    }

    @Test
    public void question2Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(1);
        homePageModel.waitForAnswerShown(1);
    }

    @Test
    public void question3Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(2);
        homePageModel.waitForAnswerShown(2);
    }

    @Test
    public void question4Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(3);
        homePageModel.waitForAnswerShown(3);
    }

    @Test
    public void question5Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(4);
        homePageModel.waitForAnswerShown(4);
    }

    @Test
    public void question6Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(5);
        homePageModel.waitForAnswerShown(5);
    }

    @Test
    public void question7Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(6);
        homePageModel.waitForAnswerShown(6);
    }

    @Test
    public void question8Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion(7);
        homePageModel.waitForAnswerShown(7);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
