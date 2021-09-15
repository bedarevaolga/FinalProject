import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;// private?

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

    public LoginPage login() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public PlayListPage createPlayList(){
        createPlayList.click();
        return new PlayListPage(driver);
    }

    public FavoriteTracksPage chooseFavoriteTracks(){
        favoriteTracks.click();
        return new FavoriteTracksPage(driver);
    }
}
