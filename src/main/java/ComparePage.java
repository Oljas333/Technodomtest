import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage {
    private WebDriver driver;

    public ComparePage(WebDriver driver) {

        this.driver = driver;
    }

    private By heading = By.xpath("//p[text()='Сравниваемые товары']");
    private By error = By.xpath("//p[text()='Нет продуктов для сравнения']");
    private By basketButton = By.xpath("//p[text()='В корзину']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public String getErrorText() {

        return driver.findElement(error).getText();
    }

    public BasketPage clickBasket() {
        driver.findElement(basketButton).click();
        return new BasketPage(driver);
    }


}
