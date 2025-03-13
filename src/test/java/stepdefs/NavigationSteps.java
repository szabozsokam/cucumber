package stepdefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.components.HeaderTopbar;

public class NavigationSteps {

    private WebDriver driver;
    private HeaderTopbar topbar;

    @Given("A Bejelentkezés oldalra navigálok$")
    public void navigate_to_login_page(){
        Actions hover = new Actions(driver);
        hover.moveToElement(topbar.loginIcon).perform();
        topbar.menuItemLogin.click();
    }

    @Given("A Regisztráció oldalra navigálok$")
    public void navigate_to_register_page(){
        Actions hover = new Actions(driver);
        hover.moveToElement(topbar.loginIcon).perform();
        topbar.menuItemRegister.click();
    }
}
