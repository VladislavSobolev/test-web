package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Обычный поиск элемента
    public LoginPage(WebDriver driver){
        super(driver);
    }
    private WebElement user = driver.findElement(By.id("username"));

    // Поиск элемента через аннотацию
    @FindBy(id = "password")
    private WebElement password;


    @FindBy(xpath = "//input[@class='btn btn-lg btn-primary btn-block']")
    private WebElement buttonLogin;

    // todo: остальные элементы страницы
    @Step("Логинимся на сайт")
    public void login(String user, String password) {

        // todo
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        saveScreenshot();
        buttonLogin.click();

    }
}
