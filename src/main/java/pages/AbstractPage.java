package pages;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import java.awt.*;
import java.awt.image.ColorModel;


// Элементы общие для всех страниц
public abstract class AbstractPage {

    protected static WebDriver driver;

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    private WebElement LOG_IN;

    @Step("Кликаем на кнопку авторизации")
    public void clickLogIn() {
        LOG_IN.click();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] saveScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }



}
