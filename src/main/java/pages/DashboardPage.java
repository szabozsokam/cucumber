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

public class DashboardPage {

    @FindBy(xpath = "//h1[text()[contains(.,'Fiókom')]")
    public WebElement accountHeader;

    public HeaderTopbar headerTopbar;

    private final String DASHBOARD_URL;

    protected WebDriver driver;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        ConfigFileReader configFileReader = new ConfigFileReader();
        this.DASHBOARD_URL = configFileReader.getConfigValue("dashboardUrl");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(DASHBOARD_URL));
        PageFactory.initElements(this.driver, this);
    }
}
