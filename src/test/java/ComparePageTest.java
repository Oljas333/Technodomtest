import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ComparePageTest {
    private WebDriver driver;
    private ComparePage comparePage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.technodom.kz/compare");
        WebElement geobutton = driver.findElement(By.xpath("//button[@class='ButtonNext ButtonNext_Size-L ButtonNext_Theme-Alpha ButtonNext_Shadow-default button']"));
        if (geobutton.isEnabled()) geobutton.click();
        comparePage = new ComparePage(driver);
    }

    @Test
    public void getHeadingText() {
        String heading = comparePage.getHeadingText();
        Assert.assertEquals("Сравниваемые товары", heading);

    }

    @Test
    public void getErrorText() {
        String error = comparePage.getErrorText();
        Assert.assertEquals("Нет продуктов для сравнения", error);
    }

    @Test
    public void clicBasketButton() {
        BasketPage basketPage = comparePage.clickBasket();
        String heading = basketPage.getHeadingText();
        Assert.assertEquals("Все категории", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
