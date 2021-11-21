package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.util.ArrayList;

public class MainPage extends AbstractPage {

    private final Select QUEUE = new Select(driver.findElement(By.xpath("//select[@name='queue']")));
    private final WebElement PROBLEM = driver.findElement(By.xpath("//input[@name='title']"));
    private final WebElement DESCRIPTION = driver.findElement(By.xpath("//textarea[@name='body']"));
    private final Select PRIORITY = new Select(driver.findElement(By.xpath("//select[@name='priority']")));
    private final WebElement DATE = driver.findElement(By.xpath("//input[@name='due_date']"));
    private final WebElement EMAIL = driver.findElement(By.xpath("//input[@name='submitter_email']"));
    private final WebElement SUB_TICKET = driver.findElement(By.xpath("//button[@type='submit']"));
    private ArrayList<String> paramters = new ArrayList<String>();




    public MainPage(WebDriver driver){
        super(driver);
    }

    @Step("Вводим название проблемы")
    public MainPage inputProblem(String problem){
        this.PROBLEM.sendKeys(problem);
        paramters.add(problem);
        saveScreenshot();
        return  this;
    }

    @Step("Вводим описание проблемы")
    public MainPage inputDescription(String description){
        this.DESCRIPTION.sendKeys(description);
        paramters.add(description);
        saveScreenshot();
        return  this;
    }

    @Step("Вводим email")
    public MainPage inputEmail(String email){
        this.EMAIL.sendKeys(email);
        paramters.add(email);
        saveScreenshot();
        return  this;
    }

    @Step("Отправляем тикет")
    public MainPage dispatch(){
        SUB_TICKET.click();
        saveScreenshot();
        return  this;
    }

    @Step("Вводим вид продукта")
    public MainPage inputQueue(String queue){
        QUEUE.selectByVisibleText(queue);
        saveScreenshot();
        return  this;
    }

    @Step("Вводим приоритет тикета")
    public MainPage inputPriority(String value){
        PRIORITY.selectByValue(value);
        saveScreenshot();
        return  this;
    }

    @Step("Вводим дату")
    public MainPage inputDate(String date){
        this.DATE.sendKeys(date);
        saveScreenshot();
        return  this;
    }
    @Step("Получаем данные тикета")
    public ArrayList<String> getParameters(){
        return paramters;
    }

}
