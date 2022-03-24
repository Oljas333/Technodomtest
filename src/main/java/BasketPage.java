import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class='cart-page__title']");
    private By error = By.xpath("//p[text()='У вас нет товаров в корзине']");
    private By basketClean = By.xpath("//p[text()='Очистить корзину']");
    private By basketButton = By.xpath("//p[text()='Оформить заказ']");
    private By officialNotice = By.xpath("//a[text()='условиями покупки']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();

    }
    public BasketPage clickBasketClean() {
        WebElement clbth = driver.findElement(basketClean);
        if (clbth.isEnabled()) clbth.click();
        return new BasketPage(driver);

    }

    public BasketPage clickBasket() {
        WebElement bebth = driver.findElement(basketButton);
        if (bebth.isEnabled()) bebth.click();
        return new BasketPage(driver);

    }

    public OfficialNoticePage clickNotice() {
        driver.findElement(officialNotice).click();
        return new OfficialNoticePage(driver);
    }


}
