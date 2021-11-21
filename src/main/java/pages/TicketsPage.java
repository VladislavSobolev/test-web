package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TicketsPage extends AbstractPage {
    public TicketsPage(WebDriver driver){
        super(driver);
    }



    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @Step("Ищем нужный тикет")
    public TicketsPage searchField(String request){
        search.click();
        search.sendKeys(request);
        saveScreenshot();
        return this;
    }

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement buttonGo;

    @Step("Нажимаем кнопку поиска")
    public TicketsPage useButtonGo(){
        buttonGo.click();
        saveScreenshot();
        return this;
    }

}
