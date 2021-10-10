package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@data-testid='login-button'] ")
    private WebElement loginButton;
    @FindBy(xpath = "//span[@data-testid=\"user-widget-name\"]")
    private WebElement userName;
    @FindBy(xpath = "//button[@class=\"PnXH8Hvc4os3tFpc10_z\"]")
    private WebElement userMenu;
    @FindBy(xpath = "//span[text()='Выйти']")
    private WebElement logoutBtn;
    @FindBy(xpath = "//span[text()='Создать плейлист']")
    private WebElement createPlayList;
    @FindBy(xpath = "//span[text()=\"Любимые треки\"]")
    private WebElement favoriteTracks;
    @FindBy(xpath = "//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]")
    private WebElement closecookie;
    @FindBy(xpath = "//span[@class=\"vQ8EkR_krbAi5mYmmpCn IAK6xuovwdsi5JG9DSTx\"]")
    private List<WebElement> listOfPlayList;

    public String getUserName() {
        return userName.getText();
    }

    public String getLoginButton() {
        return loginButton.getText();
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }

    public int numberOfPlayLists() {
        driver.navigate().refresh();
       return listOfPlayList.size();
    }

    public PlayListPage findPlayList(String playListName) {
        for (WebElement webElement : listOfPlayList) {
          if(webElement.getText().equals(playListName)) {
              webElement.click();
              return new PlayListPage(driver);
          }
        }
        return null;
    }

    public LoginPage login() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public PlayListPage createPlayList() {
        createPlayList.click();
        return new PlayListPage(driver);
    }

    public FollowPage chooseFavoriteTracks() {
        favoriteTracks.click();
        return new FollowPage(driver);
    }

    public MainPage closeCookie() {
        closecookie.click();
        return this;
    }

}
