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

    private final String LOGIN_URL;
    private final String DASHBOARD_URL;

    protected WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        ConfigFileReader configFileReader = new ConfigFileReader();
        this.LOGIN_URL = configFileReader.getConfigValue("loginUrl");
        this.DASHBOARD_URL = configFileReader.getConfigValue("dashboardUrl");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_URL));
        PageFactory.initElements(this.driver, this);
    }

    public void login(String username, String password){
        usernameIF.sendKeys(username);
        passwordIF.sendKeys(password);
        loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }
}
