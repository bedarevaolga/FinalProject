import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoriteTracksPage {
    public WebDriver driver;// private?

    public FavoriteTracksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()=\"НАЙТИ ТРЕКИ\"]")
    private WebElement findTracks;
    @FindBy(xpath = " //input[@placeholder=\"Исполнитель, трек или подкаст\"]")
    private WebElement chooseTrack;

    public FavoriteTracksPage findFavoriteTracks(String artistName, String songName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findTracks);
        findTracks.click();
chooseTrack.click();
chooseTrack.sendKeys(artistName + " " +  songName);

return this;
    }
}
