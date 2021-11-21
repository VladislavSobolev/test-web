package pages;



import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


public class CurrentTicketPage extends AbstractPage{
    public CurrentTicketPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "(//button[@class='btn btn-warning btn-sm'])[1]")
    private WebElement editButton;

    @Step("Кликаем на кнопку редактирования тикета")
    public void useEditButton(){
        editButton.click();
        saveScreenshot();
    }


}
