import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("(//span[@class='logo__label'])[2]");
    private By catalog = By.xpath("//a[@class='header-middle__catalog bottom-menu-link --accent']");
    private By allCategory = By.xpath("//p[text()='Все категории']");
    private By search = By.xpath(".//*[@id='globalSearch']");
    private By searchButton = By.xpath("//button[@class='search-bar__icon']");
    private By favorites = By.xpath("//span[text()='Избранное']");
    private By compare = By.xpath("//span[text()='Сравнить']");
    private By basket = By.xpath("//span[text()='Корзина']");
    private By login = By.xpath("//span[@class='account']");
    private By registration = By.xpath("(//p[text()='Регистрация'])[1]");


    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public CatalogPage clickCatalog() {
        driver.findElement(catalog).click();
        driver.findElement(allCategory).click();
        return new CatalogPage(driver);
    }

    public SearchPage clickSearch(String product) {
        driver.findElement(search).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public MainPage clickFavorites() {
        driver.findElement(favorites).click();
        return this;
    }

    public ComparePage clickCompare() {
        driver.findElement(compare).click();
        return new ComparePage(driver);
    }

    public BasketPage clickBasket() {
        driver.findElement(basket).click();
        return new BasketPage(driver);
    }

    public SignInPage clickLogin() {
        driver.findElement(login).click();
        return new SignInPage(driver);
    }

    public RegistrationPage clickRegistration() {
        driver.findElement(login).click();
        driver.findElement(registration).click();
        return new RegistrationPage(driver);
    }

}

