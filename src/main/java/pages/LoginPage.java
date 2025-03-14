package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.HeaderTopbar;

import java.time.Duration;

public class LoginPage {

    @FindBy(name = "login")
    private WebElement usernameIF;

    @FindBy(name = "password")
    private WebElement passwordIF;

    @FindBy(xpath = "//button[@data-key='myAccount.component.formLogin.login']")
    public WebElement loginButton;

    public HeaderTopbar headerTopbar;

    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.headerTopbar = new HeaderTopbar(this.driver);
        ConfigFileReader configFileReader = new ConfigFileReader();
        String LOGIN_URL = configFileReader.getConfigValue("loginUrl");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_URL));
        PageFactory.initElements(this.driver, this);
    }

    public void login(String username, String password){
        usernameIF.sendKeys(username);
        passwordIF.sendKeys(password);
        // negatív scenariok egy részénél nem lesz kattintható
        if (loginButton.isEnabled()) {
            loginButton.click();
        }
    }
}
