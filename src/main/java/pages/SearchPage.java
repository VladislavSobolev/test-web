package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage{
    public SearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='tickettitle']")
    private WebElement ticketTitle;

    public SearchPage openTicket(){
        ticketTitle.click();
        return this;
    }
}
