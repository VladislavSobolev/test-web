package pages;

;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage{
    public SearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='tickettitle'])[1]")
    private WebElement ticketTitle;

    @Step("Открываем тикет")
    public SearchPage openTicket(){
        ticketTitle.click();
        saveScreenshot();
        return this;
    }
}
