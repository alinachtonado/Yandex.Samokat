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
        homePageModel.clickQuestion1();
        homePageModel.waitForAnswer1Shown();
    }

    @Test
    public void question2Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion2();
        homePageModel.waitForAnswer2Shown();
    }

    @Test
    public void question3Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion3();
        homePageModel.waitForAnswer3Shown();
    }

    @Test
    public void question4Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion4();
        homePageModel.waitForAnswer4Shown();
    }

    @Test
    public void question5Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion5();
        homePageModel.waitForAnswer5Shown();
    }

    @Test
    public void question6Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion6();
        homePageModel.waitForAnswer6Shown();
    }

    @Test
    public void question7Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion7();
        homePageModel.waitForAnswer7Shown();
    }

    @Test
    public void question8Test(){
        HomePageModel homePageModel = new HomePageModel(driver);
        homePageModel.clickQuestion8();
        homePageModel.waitForAnswer8Shown();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
