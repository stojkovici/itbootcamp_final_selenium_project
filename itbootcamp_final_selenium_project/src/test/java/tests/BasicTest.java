package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BasicTest {
    protected String baseUrl;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.baseUrl = "https://vue-demo.daniel-avellaneda.com";
        this.loginPage = new LoginPage(driver,wait);
        this.navPage = new NavPage(driver,wait);
        this.signupPage = new SignupPage(driver,wait);
        this.citiesPage = new CitiesPage(driver,wait);
        this.messagePopUpPage = new MessagePopUpPage(driver,wait);
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @AfterMethod
    public void afterMethod(){

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
