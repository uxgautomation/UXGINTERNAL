package PageObjects;

import Common.TestHelper;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by AVilshinsky on 16.12.2015.
 */
public class FrontPage {
    public static String emailValue = "";
    public static String validPassword = "Uxgpassword1";

    public static String xpathInputFirstName = "//*[@id='wrapper-first-name']//input";
    public static String xpathInputLastName = "//*[@id='wrapper-last-name']//input";
    public static String xpathInputEmail = "//*[@id='wrapper-mail']//input";
    public static String xpathInputPassword = "//*[@id='wrapper-pass1']//input";
    public static String xpathInputConfirmedPassword = "//*[@id='wrapper-pass2']//input";
    public static String xpathButtonDropdownMonth = "//span[text()='Month']/parent::a|//span[text()='Mes']/parent::a";
    public static String xpathJanuaryMonth = "//span[text()='Month']/../..//li[text()='Jan']|//span[text()='Mes']/../.." +
            "//li[text()='Jan']";
    public static String xpathButtonDropdownDay = "//span[text()='Day']/parent::a|//span[text()='Día']/parent::a";
    public static String xpath1Day = "//span[text()='Day']/../..//li[text()='1']|//span[text()='Día']/../.." +
            "//li[text()='1']";
    public static String xpathButtonDropdownYear = "//span[text()='Year']/parent::a|//span[text()='Año']/parent::a";
    public static String xpath1993Year = "//span[text()='Year']/../..//li[text()='1993']|//span[text()='Año']/../.." +
            "//li[text()='1993']";
    public static String xpathRadiobuttonGender = "//input[@type='radio']";
    public static String xpathTCCheckbox = "//*[@id='edit-accept-agreement']";
    public static String xpathButtonSubmitRegistration = "//*[@id='edit-submit']";
    public static String xpathAfterRegistrationSentEmailPopUp = "//*[@class='mfp-content']";

    public static String xpathButtonRegistration = "//*[@class='wl-unreg-user-menu']/a[2]";
    public static String xpathButtonLogin = "//*[@class='wl-unreg-user-menu']/a[1]";

    public static String xpathUserAvatar = "//*[contains(@class,'user-picture')]";

    @Step("Click on Register button.")
    public static void clickOnRegisterButton() {
        TestHelper.waitXpathElement(xpathButtonRegistration).click();
    }

    @Step("Click on Log In button.")
    public static void clickOnLogInButton() {
        TestHelper.waitXpathElement(xpathButtonLogin).click();
    }







    @Step("Fill First Name input with valid value.")
    public static void fillFirstNameInput() {
        TestHelper.waitXpathElement(xpathInputFirstName).sendKeys(emailValue);
    }
    @Step("Fill Last Name input with valid value.")
    public static void fillLastNameInput() {
        TestHelper.waitXpathElement(xpathInputLastName).sendKeys("Smith");
    }
    @Step("Fill Last Name input with valid value.")
    public static void fillEmailInput() {
        TestHelper.waitXpathElement(xpathInputEmail).sendKeys(emailValue + "@mailforspam.com");
    }
    @Step("Fill Password input with valid value.")
    public static void fillPasswordInput() {
        TestHelper.waitXpathElement(xpathInputPassword).sendKeys(validPassword);
    }
    @Step("Fill Verify Password input with valid value.")
    public static void fillConfirmedPasswordInput() {
        TestHelper.waitXpathElement(xpathInputConfirmedPassword).sendKeys(validPassword);
    }
    @Step("Set month of birth.")
    public static void setBirthMonth() {
        TestHelper.scrollPage(400);
        TestHelper.waitXpathElement(xpathButtonDropdownMonth).click();
        TestHelper.waitMsec(500);
        TestHelper.waitXpathElement(xpathJanuaryMonth).click();
    }
    @Step("Set day of birth.")
    public static void setBirthDay() {
        TestHelper.waitXpathElement(xpathButtonDropdownDay).click();
        TestHelper.waitXpathElement(xpath1Day).click();
    }
    @Step("Set year of birth.")
    public static void setBirthYear() {
        TestHelper.waitXpathElement(xpathButtonDropdownYear).click();
        TestHelper.waitXpathElement(xpath1993Year).click();
    }
    @Step("Set gender.")
    public static void setGender() {
        TestHelper.driver.findElement(By.xpath(xpathRadiobuttonGender)).click();
    }
    @Step("Click on Terms & Conditions checkbox.")
    public static void agreeWithTCCheckbox() {
        TestHelper.driver.findElement(By.xpath(xpathTCCheckbox)).click();
    }
    @Step("Submit registration by click on Register button.")
    public static void submitRegistration() {
        TestHelper.moveXpathElement(xpathButtonSubmitRegistration);
        TestHelper.waitXpathElement(xpathButtonSubmitRegistration).click();
    }
    @Step("Verify that creation of new account is complete.")
    public static void verifyThatAccountIsCreated() {
        TestHelper.waitXpathElement(xpathAfterRegistrationSentEmailPopUp);
    }
    @Step("Verify that registration is passed correctly.")
    public static void verifyCompletionOfRegistration() {
        TestHelper.waitXpathElement("//*[@class='row registration-successful-dialog']");
    }
}
