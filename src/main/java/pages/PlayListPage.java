package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayListPage {
    private final WebDriver driver;

    public PlayListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder='Поиск треков и выпусков']")
    private WebElement trackSearch;
    @FindBy(xpath = "//div[@class=\"os-content\"]/descendant::span[contains(text(),\"плейлист\")]")
    private List<WebElement> playLists;
    @FindBy(xpath = "//button[@aria-label=\"Очистить строку поиска\"]")
    private WebElement cleanSearch;
    @FindBy(xpath = "//div[@data-testid=\"playlist-tracklist\"]")
    private WebElement sonsFromPlayListGeneral;
    @FindBy(xpath = "//div[@class=\"fv_p2bOQDpaYqm4EI6Ho mKF9Weo988YLlpmmr_Q4\"]//div[@class=\"_OpqIZJH2IqpNqAS9iJ7 vdyxMem0D6h0FIowNo2D\"]")
    private List<WebElement> songsFromPlayList;
    @FindBy(xpath = "//span[text()=\"Удалить из этого плейлиста\"]")
    private WebElement deleteFromPlayList;
    @FindBy(xpath = "//span[contains(text(),\"Удалить\")]")
    private WebElement deletePlayList;
    @FindBy(xpath = "//div[@class = '_OpqIZJH2IqpNqAS9iJ7 vdyxMem0D6h0FIowNo2D']")
    private WebElement songNames;
    @FindBy(xpath = "//button[text()=\"УДАЛИТЬ\"]")
    private WebElement deleteBtn;
    @FindBy(xpath = "//div[@class=\"fv_p2bOQDpaYqm4EI6Ho mKF9Weo988YLlpmmr_Q4\"]")
    private WebElement itemsListOfPlayList;
    @FindBy(xpath = "//button[@class=\"HeBhibwzuyWAXBm9vJlm\"]")
    private WebElement buttonMore;
    private static final By addToPlayList = By.xpath("//button[@data-testid=\"add-to-playlist-button\"]");

    public PlayListPage addComposition(String artistName, String songName) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trackSearch);
        trackSearch.click();
        trackSearch.sendKeys(artistName + " " + songName + "\n");
        songNames.findElement(addToPlayList).click();
        cleanSearch.click();
        driver.navigate().refresh();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonMore);
        buttonMore.click();
        return this;
    }

    public PlayListPage deleteComposition(String artistName, String songName) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        for (WebElement webElement : songsFromPlayList) {
            if (webElement.getText().contains(artistName) && webElement.getText().contains(songName)) {
                Actions action = new Actions(driver);
                action.moveToElement(webElement);
                action.contextClick(webElement).perform();
                driver.switchTo();
                deleteFromPlayList.click();
                driver.navigate().refresh();
                return this;
            }
        }
        return this;
    }


    public boolean isCompositionAddedToPlayList(String artistName, String songName) {
        Actions action = new Actions(driver);
        action.moveToElement(sonsFromPlayListGeneral);
        action.perform();
        String playListInformation = sonsFromPlayListGeneral.getText();
        return (playListInformation.contains(artistName) && playListInformation.contains(songName));
    }

    public PlayListPage deletePlayList(String namePlayList) {
        Actions action = new Actions(driver);
        action.moveToElement(findPlayList(namePlayList)).contextClick().perform();
        driver.switchTo();
        deletePlayList.click();
        deleteBtn.click();
        driver.navigate().refresh();
        return this;
    }

    public WebElement findPlayList(String namePlayList) {
        for (WebElement playList : playLists) {
            if (playList.getText().contains(namePlayList)) {
                return playList;
            }
        }
        return null;
    }

    public List<String> getListOfPlayListName() {
        List<String> listOfPlayList = new ArrayList<>();
        for (WebElement playList : playLists) {
            listOfPlayList.add(playList.getText());
        }
        return listOfPlayList;
    }
}
