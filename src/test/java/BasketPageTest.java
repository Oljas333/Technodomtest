import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BasketPageTest {
    private WebDriver driver;
    private BasketPage basketPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.technodom.kz/cart");
        WebElement geobutton = driver.findElement(By.xpath("//button[@class='ButtonNext ButtonNext_Size-L ButtonNext_Theme-Alpha ButtonNext_Shadow-default button']"));
        if (geobutton.isEnabled()) geobutton.click();
        basketPage = new BasketPage(driver);


    }

    @Test
    public void getHeadingText() {
        String heading = basketPage.getHeadingText();
        Assert.assertEquals("Корзина", heading);
    }

    @Test
    public void clickBasket() {
        BasketPage newBasketPage = basketPage.clickBasket();
        String error = basketPage.getErrorText();
        Assert.assertEquals("У вас нет товаров в корзине", error);

    } @Test
    public void clickBasketClean() {
        BasketPage newBasketPage = basketPage.clickBasketClean();
        String error = basketPage.getErrorText();
        Assert.assertEquals("У вас нет товаров в корзине", error);

    }
    @Test
    public void getErrorText() {
        String error = basketPage.getErrorText();
        System.out.println(error);
        Assert.assertEquals("У вас нет товаров в корзине", error);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
