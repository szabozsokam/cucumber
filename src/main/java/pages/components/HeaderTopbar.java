package pages.components;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HeaderTopbar {

    @FindBy(xpath = "//div[@class='headerTopbar']")
    public WebElement headerTopbar;

    @FindBy(xpath = "//map[@name='account']")
    public WebElement accountIcon;

    @FindBy(xpath = "//button[@data-key='core.component.header.loginButtonLabel']")
    public WebElement menuItemLogin;

    @FindBy(xpath = "//u[@data-key='core.component.header.registerLabel']")
    public WebElement menuItemRegister;

    @FindBy(xpath = "//a[@data-key='core.component.header.userInfo.logoutHint']")
    public WebElement logoutLink;

    protected WebDriver driver;

    public HeaderTopbar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(headerTopbar));
    }

    public void clickLoginMenu(){
        new Actions(driver).moveToElement(accountIcon).moveToElement(menuItemLogin).click().perform();
        ConfigFileReader configFileReader = new ConfigFileReader();
        String loginUrl = configFileReader.getConfigValue("loginUrl");
        if (!Objects.equals(driver.getCurrentUrl(), loginUrl)){
            driver.navigate().to(loginUrl);
        }
    }

    public void clickRegisterMenu(){
        new Actions(driver).moveToElement(accountIcon).moveToElement(menuItemRegister).click().perform();
        ConfigFileReader configFileReader = new ConfigFileReader();
        String registerUrl = configFileReader.getConfigValue("registerUrl");
        if (!Objects.equals(driver.getCurrentUrl(), registerUrl)){
            driver.navigate().to(registerUrl);
        }
    }

    public void logout(){
        new Actions(driver).moveToElement(accountIcon).moveToElement(logoutLink).click().perform();
        ConfigFileReader configFileReader = new ConfigFileReader();
        String logoutUrl = configFileReader.getConfigValue("logoutUrl");
        if (!Objects.equals(driver.getCurrentUrl(), logoutUrl)){
            driver.navigate().to(logoutUrl);
        }
    }
}
