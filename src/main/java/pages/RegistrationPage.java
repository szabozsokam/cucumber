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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RegistrationPage {

    private final ConfigFileReader configFileReader;
    private final String REGISTER_URL;
    private final String DASHBOARD_URL;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String street;
    private String number;
    private String postalCode;
    private String city;


    @FindBy(xpath = "//button[@data-key='register.component.gendertype.person']")
    private WebElement personRB;

    @FindBy(id = "delivery-firstName")
    private WebElement firstNameIF;

    @FindBy(id = "delivery-lastName")
    private WebElement lastNameIF;

    @FindBy(id = "delivery-email")
    private WebElement emailIF;

    @FindBy(id = "delivery-phone")
    private WebElement phoneIF;

    @FindBy(id = "delivery-password")
    private WebElement passwordIF;

    @FindBy(id = "delivery-line1")
    private WebElement streetIF;

    @FindBy(id = "delivery-line2")
    private WebElement houseNumberIF;

    @FindBy(id = "delivery-appartment")
    private WebElement supplementaryInfoIF;

    @FindBy(id = "delivery-postalCode")
    private WebElement postalCodeIF;

    @FindBy(id = "delivery-town")
    private WebElement cityIF;

    @FindBy(xpath = "//span[@data-key='core.component.formOrderConfirmationRegister.privacyPolicyConfirmed']")
    public WebElement privacyPolicyCB;

    @FindBy(xpath = "//button[@data-key='register.component.register']")
    public WebElement registerButton;

    public HeaderTopbar headerTopbar;

    protected WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.configFileReader = new ConfigFileReader();
        this.REGISTER_URL = configFileReader.getConfigValue("registerUrl");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(REGISTER_URL));
        PageFactory.initElements(this.driver, this);
        String timestamp = this.generateTimestamp();
        this.lastName = "Test" + timestamp;
        this.email = this.lastName + "@gmail.com";
        this.phone = this.generateRandomPhoneNumber();
        this.firstName = configFileReader.getConfigValue("regFirstName");
        this.street = configFileReader.getConfigValue("regStreet");
        this.number = configFileReader.getConfigValue("regHNumber");
        this.postalCode = configFileReader.getConfigValue("regPostalCode");
        this.city = configFileReader.getConfigValue("regCity");
        this.password = configFileReader.getConfigValue("password");
        this.DASHBOARD_URL = configFileReader.getConfigValue("dashboardUrl");
    }

    private String generateTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        return now.format(formatter);
    }

    private String generateRandomPhoneNumber(){
        Random random = new Random();
        int min = 1000000;
        int max = 9999999;
        String phoneNumber = String.valueOf(random.nextInt( max - min) + min);
        return "+3620" + phoneNumber;
    }

    public void registrateAsPerson(){
        personRB.click();
        firstNameIF.sendKeys(firstName);
        lastNameIF.sendKeys(lastName);
        emailIF.sendKeys(email);
        phoneIF.sendKeys(phone);
        passwordIF.sendKeys(password);
        streetIF.sendKeys(street);
        houseNumberIF.sendKeys(number);
        postalCodeIF.sendKeys(postalCode);
        cityIF.sendKeys(city);
        privacyPolicyCB.click();
        registerButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }

}
