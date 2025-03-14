package stepdefs;

import io.cucumber.java.hu.Akkor;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;
import pages.StartPage;

import static stepdefs.Hooks.driver;

public class DashboardsSteps {

    @Akkor("A fiókomba jutok")
    public void aFiókombaJutok() {
        Actions hover = new Actions(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        hover.moveToElement(dashboardPage.headerTopbar.accountIcon).perform();
        Assertions.assertTrue(dashboardPage.accountMenuTitle.isDisplayed());
        dashboardPage.headerTopbar.logout();
        StartPage startPage = new StartPage(driver);
        Assertions.assertTrue(startPage.headerTopbar.menuItemLogin.isEnabled());
    }

    @Akkor("A fiókom létrejön")
    public void aFiókomLétrejön() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assertions.assertTrue(dashboardPage.newAccountHeader.isDisplayed());
        dashboardPage.headerTopbar.logout();
        StartPage startPage = new StartPage(driver);
        Assertions.assertTrue(startPage.headerTopbar.menuItemLogin.isEnabled());
    }
}
