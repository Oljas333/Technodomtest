import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private MainPage mainPage;



    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.technodom.kz/compare");
        WebElement geobutton = driver.findElement(By.xpath("//button[@class='ButtonNext ButtonNext_Size-L ButtonNext_Theme-Alpha ButtonNext_Shadow-default button']"));
        if (geobutton.isEnabled()) geobutton.click();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void register() {
        RegistrationPage registrationPage = mainPage.clickRegistration();
        RegistrationPage newRegistrationPage = registrationPage.register("Oljas", "Kuss", "test@em.ru", "77700000000", "dfhzdf");

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
