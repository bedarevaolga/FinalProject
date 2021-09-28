package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class LoginPage {

    private WebDriver driver;// privat?

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name = 'username']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwdField;
    @FindBy(xpath = "//button[@id = 'login-button']")
    private WebElement loginBtn;

    @Step("input Login")
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("input Password")
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    @Step("submit login and password")
    public void clickLoginBtn() {
        loginBtn.click();
    }
}



