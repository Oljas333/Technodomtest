import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CatalogPageTest {
    private WebDriver driver;
    private CatalogPage catalogPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.technodom.kz/catalog");
        WebElement geobutton = driver.findElement(By.xpath("//button[@class='ButtonNext ButtonNext_Size-L ButtonNext_Theme-Alpha ButtonNext_Shadow-default button']"));
        if (geobutton.isEnabled()) geobutton.click();
        catalogPage = new CatalogPage(driver);
    }
    @Test
    public void getHeadingText() {
        String heading = catalogPage.getHeadingText();
        Assert.assertEquals("Все категории", heading);
    }
    @Test
    public void choiceСatalogNavigation() {
        CatalogPage newCatalogPage = catalogPage.typeCatalogNavigation(5);
        String heading = catalogPage.getHeadingText();
        Assert.assertEquals("Все категории", heading);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
