package uiTest;

import config.Config;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FollowPage;
import pages.LoginPage;
import pages.MainPage;
import pages.PlayListPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;
    public static PlayListPage playListPage;
    public static FollowPage followPage;
    // private static Properties testProperties;

    @BeforeAll
    public static void testSetup() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        playListPage = new PlayListPage(driver);
        followPage = new FollowPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getURLMainPage());
    }

    @Order(1)
    @Test
    public void testLogin() {
        mainPage.login();
        loginPage.inputLogin(Config.USER_LOGIN);
        loginPage.inputPasswd(Config.USER_PASSWORD);
        loginPage.clickLoginBtn();
        String user = mainPage.getUserName();
        Assertions.assertEquals(Config.USER_NAME, user);
    }

    @Order(2)
    @Test
    public void testCreatePlayList() {
        mainPage.createPlayList();
        Assertions.assertEquals("Мой плейлист № 3", playListPage.getPlayListName());
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource({"AC/DC, Highway to Hell", "Dido, White Flag", "Madonna, Frozen"})
    public void testAddCompositionToPlayList(String artistName, String songName) {
        playListPage.addComposition(artistName, songName);
        Assertions.assertTrue(playListPage.isCompositionAddedToPlayList(artistName, songName));
    }

    @Order(4)
    @ParameterizedTest
    @CsvSource({"Madonna, Frozen"})
    public void testDeleteCompositionToPlayList(String artistName, String songName) {
        playListPage.deleteComposition(artistName, songName);
        Assertions.assertFalse(playListPage.isCompositionAddedToPlayList(artistName, songName));
    }

    @Order(5)
    @ParameterizedTest
    @CsvSource({"Мой плейлист № 3"})
    public void testDeletePlayList(String namePlayList) {
        playListPage.deletePlayList(namePlayList);
        Assertions.assertFalse(playListPage.getListOfPlayListName().contains(namePlayList));
    }

    @Order(6)
    @ParameterizedTest
    @CsvSource({"Arctic Monkeys"})
    public void testFollow(String artistName) {
        mainPage.chooseFavoriteTracks();
        followPage.findFavoriteArtist(artistName);
        Assertions.assertEquals("ПОДПИСКА", followPage.subscription());
    }

    @Order(7)
    @Test
    public void testLogout() {
        mainPage.entryMenu();
        mainPage.userLogout();
        Assertions.assertEquals("ВОЙТИ", mainPage.getLoginButton());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}


