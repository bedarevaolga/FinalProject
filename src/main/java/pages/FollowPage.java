package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FollowPage {
    private final WebDriver driver;

    public FollowPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()=\"НАЙТИ ТРЕКИ\"]")
    private WebElement findItem;
    @FindBy(xpath = "//input[@placeholder=\"Исполнитель, трек или подкаст\"]")
    private WebElement chooseItem;
    @FindBy(xpath = "//section[@aria-label=\"Лучший результат\"]")
    private WebElement bestResultOfSearch;
    @FindBy(xpath = "//button[contains(@class,\"_2qGqWaiZbWlHPjjDGxS\")]")
    private WebElement followBtn;

    public FollowPage findFavoriteArtist(String artistName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findItem);
        findItem.click();
        chooseItem.click();
        chooseItem.sendKeys(artistName + "\n");
        bestResultOfSearch.click();
        followBtn.click();
        return this;
    }

    public String subscription() {
        return followBtn.getText();
    }
}
