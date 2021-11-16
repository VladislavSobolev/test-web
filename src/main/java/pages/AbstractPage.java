package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Элементы общие для всех страниц
public abstract class AbstractPage {

    protected static WebDriver driver;

    public AbstractPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @FindBy(xpath =  "//a[@class='nav-link dropdown-toggle']")
    private  WebElement LOG_IN;

    public void clickLogIn(){
        LOG_IN.click();
    }

}
