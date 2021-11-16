package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;

public class EditPage extends AbstractPage{
    public EditPage(WebDriver driver){
        super(driver);
    }

    private ArrayList<String> ticket = new ArrayList<String>();

    @FindBy(xpath = "//input[@name='title']")
    private WebElement title;


    @FindBy(xpath = "//input[@name='submitter_email']")
    private WebElement email;


    @FindBy(xpath = "(//*[@class=' form-control'])[4]")
    private WebElement description;


    public void buildTicket(){
        ticket.add(title.getAttribute("value"));
        ticket.add(description.getText());
        ticket.add(email.getAttribute("value"));
    }

    public ArrayList<String> getTicket(){
        return ticket;
    }

}
