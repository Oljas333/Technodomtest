import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName = By.xpath(".//*[@id='create-account-form__name']");
    private By userLastName = By.xpath(".//*[@id='create-account-form__last-name']");
    private By emailUser = By.xpath(".//*[@id='create-account-form__email']");
    private By userPhone = By.xpath(".//*[@id='create-account-form__phone']");
    private By userPassword = By.xpath(".//*[@id='create-account-form__password']");
    private By userConfirmPassword = By.xpath(".//*[@id='create-account-form__confirm-password']");
    private By customInput = By.xpath("//span[@class='CheckboxNext__CustomInput']");
    private By registrationButton = By.xpath("(//p[text()='Регистрация'])[2]");
    private By closeButton = By.xpath("//button[@class='Authorization__CloseBtn']");


    public RegistrationPage typeUserName(String username) {
        driver.findElement(userName).sendKeys(username);
        return this;
    }

    public RegistrationPage typeUserLastName(String userlastname) {
        driver.findElement(userLastName).sendKeys(userlastname);
        return this;
    }


    public RegistrationPage typeEmail(String email) {
        driver.findElement(emailUser).sendKeys(email);
        return this;
    }

    public RegistrationPage typePhone(String phone) {
        driver.findElement(userPhone).sendKeys(phone);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        driver.findElement(userPassword).sendKeys(password);
        return this;
    }

    public RegistrationPage typeConfirmPassword(String password) {
        driver.findElement(userConfirmPassword).sendKeys(password);
        return this;
    }

    public RegistrationPage typeCustom() {
        driver.findElement(customInput).click();
        return this;
    }


    public RegistrationPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return this;
    }

    public RegistrationPage clickCloseButton() {
        driver.findElement(closeButton).click();
        return this;
    }


    public RegistrationPage register(String username, String userlastname, String email, String phone, String password) {
        this.typeUserName(username);
        this.typeUserLastName(userlastname);
        this.typeEmail(email);
        this.typePhone(phone);
        this.typePassword(password);
        this.typeConfirmPassword(password);
        this.typeCustom();
        this.clickRegistrationButton();
        return new RegistrationPage(driver);
    }
}
