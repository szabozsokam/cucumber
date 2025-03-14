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

    @FindBy(xpath = "//h1[text()[contains(.,'Fiókom')]]")
    public WebElement newAccountHeader;

    @FindBy(xpath = "//strong[text()[contains(.,'Fiókom')]]")
    public WebElement accountMenuTitle;

    public HeaderTopbar headerTopbar;


    public DashboardPage(WebDriver driver) {
        this.headerTopbar = new HeaderTopbar(driver);
        ConfigFileReader configFileReader = new ConfigFileReader();
        String DASHBOARD_URL = configFileReader.getConfigValue("dashboardUrl");
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.urlToBe(DASHBOARD_URL));
        PageFactory.initElements(driver, this);
    }
}
