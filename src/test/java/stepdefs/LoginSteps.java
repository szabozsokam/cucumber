package stepdefs;


import dataProvider.ConfigFileReader;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amikor;
import io.cucumber.java.hu.És;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import static stepdefs.Hooks.driver;

public class LoginSteps {

    @Amikor("Bejelentkezek korábban létrehozott felhasználóval")
    public void bejelentkezekKorábbanLétrehozottFelhasználóval() {
        LoginPage loginPage = new LoginPage(driver);
        ConfigFileReader configFileReader = new ConfigFileReader();
        String savedUser = configFileReader.getConfigValue("savedUser");
        String pw = configFileReader.getConfigValue("password");
        loginPage.login(savedUser, pw);
    }

    @Amikor("Bejelentkezek <felhasználó> és <jelszó> adatokkal")
    public void bejelentkezekFelhasználóÉsJelszóAdatokkal(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, password);
    }

    @Akkor("<hibaüzenet> szöveg jelenik meg")
    public void hibaüzenetSzövegJelenikMeg(String errorMessage) {
        WebElement message = driver.findElement(By.xpath("//span [text()[contains(.,$errorMessage]"));
        Assertions.assertTrue(message.isDisplayed());
    }

    @És("A bejelentkezés oldalon maradok")
    public void aBejelentkezésOldalonMaradok() {
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
