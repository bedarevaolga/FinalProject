package ui;

import configuration.Config;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginLogoutTest {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;
    private static final Logger log = Logger.getLogger(UiTest.class);

    @BeforeAll
    public static void testSetup() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getURLMainPage());
        log.info("Site opened");

    }


    @Tag("uiLoginLogoutTest")
    @Order(1)
    @Test
    public void testLogin() {
        mainPage.login();
        loginPage.inputLogin(Config.USER_LOGIN);
        loginPage.inputPasswd(Config.USER_PASSWORD);
        loginPage.clickLoginBtn();
        log.info("Initialization completed");
        String user = mainPage.getUserName();
        Assertions.assertEquals(Config.USER_NAME, user);
        log.info("Assertion testLogin passed");
        mainPage.closeCookie();
    }


    @Tag("uiLoginLogoutTest")
    @Order(2)
    @Test
    public void testLogout() {
        mainPage.entryMenu();
        mainPage.userLogout();
        log.info("user logout");
        Assertions.assertEquals("ВОЙТИ", mainPage.getLoginButton());
        log.info("Assertion testLogout passed");
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
        log.info("site closed");
    }
}
