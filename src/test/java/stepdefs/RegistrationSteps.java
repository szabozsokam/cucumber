package stepdefs;

import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amikor;
import io.cucumber.java.hu.És;
import org.junit.jupiter.api.Assertions;
import pages.RegistrationPage;

import static stepdefs.Hooks.driver;

public class RegistrationSteps {

    @Amikor("Teljesen kitöltöm és beküldöm a regisztrációt")
    public void teljesenKitöltömÉsBeküldömARegisztrációt() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerAsPerson();
    }

    @Amikor("Hiányosan kitöltöm és beküldöm a regisztrációt")
    public void hiányosanKitöltömÉsBeküldömARegisztrációt() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerIncomplete();
    }

    @Akkor("Hibaüzenet jelzi a kitöltendő mezőt")
    public void hibaüzenetJelziAKitöltendőMezőt() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String errorMessage = "A mező kitöltése kötelező.";
        Assertions.assertEquals(errorMessage, registrationPage.errorMessages.get(0).getText().trim());
    }

    @És("A Regisztráció oldalon maradok")
    public void aRegisztrációOldalonMaradok() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assertions.assertTrue(registrationPage.registerButton.isDisplayed());
    }
}
