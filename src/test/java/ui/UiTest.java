package ui;

import configuration.Config;
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

import java.util.concurrent.TimeUnit;

public class UiTest {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;
    public static PlayListPage playListPage;
    public static FollowPage followPage;
    private static final Logger log = Logger.getLogger(UiTest.class);

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
        log.info("Site opened");
        mainPage.login();
        loginPage.inputLogin(Config.USER_LOGIN);
        loginPage.inputPasswd(Config.USER_PASSWORD);
        loginPage.clickLoginBtn();
        log.info("Initialization completed");
        mainPage.closeCookie();
    }

    @Tag("uitest")
    @Test
    public void testCreatePlayList() {
        int numberOfPL = mainPage.numberOfPlayLists();
        log.info("number of PlayLists at this moment is : " + numberOfPL);
        mainPage.createPlayList();
        log.info("PlayList is created");
        int numberOfPLAfterCreating = mainPage.numberOfPlayLists();
        Assertions.assertEquals(numberOfPL+1, numberOfPLAfterCreating);
        log.info("new number of PlayLists at this moment after creating new PL is: " + numberOfPLAfterCreating);
        log.info("Assertion testCreatePlayList passed");
    }

    @Tag("uitest")
    @ParameterizedTest
    @CsvSource({"AC/DC, Highway to Hell, Мой плейлист № 2", "Dido, White Flag, Мой плейлист № 2", "Madonna, Frozen, Мой плейлист № 2"})
    public void testAddCompositionToPlayList(String artistName, String songName, String playListName) {
        mainPage.findPlayList(playListName);
        log.info("Play List is found");
        playListPage.addComposition(artistName, songName);
        log.info("composition is added");
        Assertions.assertTrue(playListPage.isCompositionAddedToPlayList(artistName, songName));
        log.info("Assertion testAddCompositionToPlayList passed");
    }

    @Tag("uitest")
    @ParameterizedTest
    @CsvSource({"Ace of Base, All That She Wants, Мой плейлист № 3"})
    public void testDeleteCompositionToPlayList(String artistName, String songName, String playListName) {
        mainPage.findPlayList(playListName);
        log.info("Play List is found");
        playListPage.deleteComposition(artistName, songName);
        log.info("composition " + songName + " is deleted");
        Assertions.assertFalse(playListPage.isCompositionAddedToPlayList(artistName, songName));
        log.info("Assertion testDeleteCompositionToPlayList passed");
    }

    @Tag("uitest")
    @ParameterizedTest
    @CsvSource({"Мой плейлист № 4"})
    public void testDeletePlayList(String namePlayList) {
        playListPage.deletePlayList(namePlayList);
        log.info("playlist " + namePlayList + " deleted");
        Assertions.assertFalse(playListPage.getListOfPlayListName().contains(namePlayList));
        log.info("Assertion testDeletePlayList passed");
    }

    @Tag("uitest")
    @ParameterizedTest
    @CsvSource({"Arctic Monkeys"})
    public void testFollow(String artistName) {
        mainPage.chooseFavoriteTracks();
        followPage.findFavoriteArtist(artistName);
        log.info("follow an artist completed");
        Assertions.assertEquals("ПОДПИСКА", followPage.subscription());
        log.info("Assertion  testFollow passed");
    }

    @AfterAll
    public static void tearDown() {
        mainPage.entryMenu();
        mainPage.userLogout();
        log.info("user logout");
        driver.close();
        driver.quit();
        log.info("site closed");
    }
}


