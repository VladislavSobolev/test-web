package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class CurrentTicketPage extends AbstractPage{
    public CurrentTicketPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "(//button[@class='btn btn-warning btn-sm'])[1]")
    private WebElement editButton;

    public void useEditButton(){
        editButton.click();
    }

}
