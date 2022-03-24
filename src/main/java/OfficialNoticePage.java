import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficialNoticePage {
    private WebDriver driver;

    public OfficialNoticePage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//span[text()='Официальное уведомление']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }
}
