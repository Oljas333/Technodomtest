import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userPhone = By.xpath(".//*[@id='sign-in-form__phone']");
    private By userPassword = By.xpath(".//*[@id='sign-in-form__password']");
    private By signInButton = By.xpath("//p[text()='Войти']");
    private By closeButton = By.xpath("//button[@class='Authorization__CloseBtn']");

    public SignInPage typePhone(String phone) {
        driver.findElement(userPhone).sendKeys(phone);
        return this;
    }

    public SignInPage typePassword(String password) {
        driver.findElement(userPassword).sendKeys(password);
        return this;
    }

    public SignInPage clickRegistrationButton() {
        driver.findElement(signInButton).click();
        return this;
    }

    public SignInPage clickCloseButton() {
        driver.findElement(closeButton).click();
        return this;
    }
}
