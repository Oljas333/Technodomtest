import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//span[text()='Результаты']");
    private By sorting = By.xpath("//span[text()='Сортировать по:']");
    private By category = By.xpath("//div[@class='TagFilterGroup__Content TagFilterGroup__Content_Opened TagFilterGroup__Content_Expanded']//div[@class='category-filters__filter-checkbox-sign']");
    private By brand = By.xpath("(//div[@class='TagFilterGroup__Content TagFilterGroup__Content_Opened TagFilterGroup__Content_Gradient'])[1]//div[@class='TagNext']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public SearchPage typeSelectSorting(String option) {
        String listXpath = String.format("//span[text()='Сортировать по:']");
        String optionXpath = String.format("//span[text()='%s']", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }

    public SearchPage typeSelectCategory(Integer index) {
        List<WebElement> list1 = driver.findElements(category);
       list1.get(index).click();
        return this;

    }
    public SearchPage typeSelectBrand(Integer index) {
        List<WebElement> list1 = driver.findElements(brand);
        list1.get(index).click();
        return this;
    }

}
