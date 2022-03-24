import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//span[text()='Все категории']");
    private By catalogNavigation = By.xpath("//ul[@class='catalog-page__navigation']/li");


    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public CatalogPage typeCatalogNavigation( Integer index) {
        List<WebElement> list = driver.findElements(catalogNavigation);
        list.get(index);
        return this;
    }
}
