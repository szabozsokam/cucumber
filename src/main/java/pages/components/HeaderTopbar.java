package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderTopbar {

    @FindBy(xpath = "//div[@class='headerTopbar']")
    public WebElement headerTopbar;

    @FindBy(xpath = "//a[@href='hu-hu/login']")
    public WebElement loginIcon;

    @FindBy(xpath = "//button[@data-key='core.component.header.loginButtonLabel']")
    public WebElement menuItemLogin;

    @FindBy(xpath = "//a[@href='hu-hu/register']")
    public WebElement menuItemRegister;

    protected WebDriver driver;

    public HeaderTopbar(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(headerTopbar));
        PageFactory.initElements(this.driver, this);
    }
}
