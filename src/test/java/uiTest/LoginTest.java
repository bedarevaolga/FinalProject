package uiTest;

import config.Config;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FollowPage;
import pages.LoginPage;
import pages.MainPage;
import pages.PlayListPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;
    public static PlayListPage playListPage;
    public static FollowPage followPage;
//    private static Properties testProperties;
    private static Logger log = Logger.getLogger(LoginTest.class);

    @BeforeAll
    public static void testSetup() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        playListPage = new PlayListPage(driver);
        followPage = new FollowPage(driver);
 //       testProperties = new Properties();
//        for (Object entry : testProperties.entrySet()) {
//            log.debug("property value:"+entry.toString());
//        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getURLMainPage());
        log.info("Site opened");

    }

    @Tag("uitest")
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

    @Tag("uitest")
    @Order(2)
    @Test
    public void testCreatePlayList() {
        mainPage.createPlayList();
        log.info("PlayList is created");
        Assertions.assertEquals("Мой плейлист № 3", playListPage.getPlayListName());
        log.info("Assertion testCreatePlayList passed");
    }

    @Tag("uitest")
    @Order(3)
    @ParameterizedTest
    @CsvSource({"AC/DC, Highway to Hell", "Dido, White Flag", "Madonna, Frozen"})
    public void testAddCompositionToPlayList(String artistName, String songName) {
        playListPage.addComposition(artistName, songName);
        log.info("composition is added");
        Assertions.assertTrue(playListPage.isCompositionAddedToPlayList(artistName, songName));
        log.info("Assertion testAddCompositionToPlayList passed");
    }

    @Tag("uitest")
    @Order(4)
    @ParameterizedTest
    @CsvSource({"Madonna, Frozen"})
    public void testDeleteCompositionToPlayList(String artistName, String songName) {
        playListPage.deleteComposition(artistName, songName);
        log.info("composition is deleted");
        Assertions.assertFalse(playListPage.isCompositionAddedToPlayList(artistName, songName));
        log.info("Assertion testDeleteCompositionToPlayList passed");
    }

    @Tag("uitest")
    @Order(5)
    @ParameterizedTest
    @CsvSource({"Мой плейлист № 3"})
    public void testDeletePlayList(String namePlayList) {
        playListPage.deletePlayList(namePlayList);
        log.info("playlist deleted");
        Assertions.assertFalse(playListPage.getListOfPlayListName().contains(namePlayList));
        log.info("playlist testDeletePlayList deleted");
    }

    @Tag("uitest")
    @Order(6)
    @ParameterizedTest
    @CsvSource({"Arctic Monkeys"})
    public void testFollow(String artistName) {
        mainPage.chooseFavoriteTracks();
        followPage.findFavoriteArtist(artistName);
        log.info("follow an artist completed");
        Assertions.assertEquals("ПОДПИСКА", followPage.subscription());
        log.info("Assertion  testFollow passed");
    }

    @Tag("uitest")
    @Order(7)
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


