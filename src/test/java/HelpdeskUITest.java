import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;


    @Before
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));

        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
        driver.get(System.getProperty("site.url"));
    }

    @Test
    public void createTicketTest() throws IOException {

        MainPage mainPage = new MainPage(driver);
        mainPage.inputQueue("Some Product")
                 .inputProblem("Веб тестирование")
                 .inputDescription("Первое веб тестирование")
                 .inputPriority("2")
                 .inputDate("2021-11-28 00:00:00")
                 .inputEmail("user@gmail.com")
                 .dispatch()
                 .clickLogIn();


        // todo: чтение данных учетной записи пользователя из user.properties в System.properties

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(System.getProperty("user"), System.getProperty("password"));

        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.inSearch("user@gmail.com").useButtonGo();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.openTicket();

        CurrentTicketPage currentTicketPage = new CurrentTicketPage(driver);
        currentTicketPage.useEditButton();

        EditPage editPage = new EditPage(driver);
        editPage.buildTicket();

        Assert.assertEquals(mainPage.getParameters(), editPage.getTicket());

        driver.close();
    }

}
