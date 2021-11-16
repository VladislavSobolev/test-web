package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TicketsPage extends AbstractPage {
    public TicketsPage(WebDriver driver){
        super(driver);
    }



    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    public TicketsPage inSearch(String request){
        search.click();
        search.sendKeys(request);
        return this;
    }

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement buttonGo;

    public TicketsPage useButtonGo(){
        buttonGo.click();
        return this;
    }

}
