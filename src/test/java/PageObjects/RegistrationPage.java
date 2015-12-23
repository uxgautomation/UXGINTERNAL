package PageObjects;

import Common.Environments;
import Common.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegistrationPage {
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

    public static String xpathFirstNameErrorMessage = "//*[contains(text(),'Please enter First Name.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un nombre y apellido válidos.')]";
    public static String xpathLastNameErrorMessage = "//*[contains(text(),'Please enter Last Name.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un nombre y apellido válidos.')]";
    public static String xpathEmailErrorMessage = "//*[contains(text(),'Please enter a valid email address.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un correo electrónico válido.')]";
    public static String xpathPasswordErrorMessage = "//*[@id='wrapper-pass1']//*[contains(text(),'Please enter a valid password containing at least')]" +
            "|//*[@id='wrapper-pass1']//*[contains(text(),'Tu contraseña debe tener')]";
    public static String xpathVerifyPasswordErrorMessage = "//*[@id='wrapper-pass2']//*[contains(text(),'Please enter a valid password containing at least')]" +
            "|//*[@id='wrapper-pass2']//*[contains(text(),'Tu contraseña debe tener')]";
    public static String xpathDateOfBirthErrorMessage = "//*[contains(text(),'Please enter your date of birth.')]" +
            "|//*[contains(text(),'Necesitamos tu fecha de nacimiento (Es solo para asegurarnos que tienes más de 18 años).')]";
    public static String xpathGenderErrorMessage = "//*[contains(text(),'Please select Gender.')]" +
            "|//*[contains(text(),'Por favor seleccione el género.')]";
    public static String xpathTCErrorMessage = "//*[contains(text(),'Please read and agree with the Terms and Conditions.')]" +
            "|//*[contains(text(),'Debes aceptar los términos y condiciones para poder registrarte.')]";

    public static String engRegister = "//*[contains(text(),'Register')]";
    public static String spaRegistrate = "//*[contains(text(),'Regístrate')]";


    public static void fillFirstNameInput() {
        TestHelper.waitXpathElement(xpathInputFirstName).sendKeys(Environments.emailValue);
    }
    public static void fillLastNameInput() {
        TestHelper.waitXpathElement(xpathInputLastName).sendKeys("Smith");
    }
    public static void fillEmailInput() {
        TestHelper.waitXpathElement(xpathInputEmail).sendKeys(Environments.emailValue + "@mailforspam.com");
    }
    public static void fillPasswordInput() {
        TestHelper.waitXpathElement(xpathInputPassword).sendKeys(Environments.validPassword);
    }
    public static void fillConfirmedPasswordInput() {
        TestHelper.waitXpathElement(xpathInputConfirmedPassword).sendKeys(Environments.validPassword);
    }
    public static void setBirthMonth() {
        TestHelper.scrollPage(400);
        TestHelper.waitXpathElement(xpathButtonDropdownMonth).click();
        TestHelper.waitMsec(500);
        TestHelper.waitXpathElement(xpathJanuaryMonth).click();
    }
    public static void setBirthDay() {
        TestHelper.waitXpathElement(xpathButtonDropdownDay).click();
        TestHelper.waitXpathElement(xpath1Day).click();
    }
    public static void setBirthYear() {
        TestHelper.waitXpathElement(xpathButtonDropdownYear).click();
        TestHelper.waitXpathElement(xpath1993Year).click();
    }
    public static void setGender() {
        TestHelper.driver.findElement(By.xpath(xpathRadiobuttonGender)).click();
    }
    public static void agreeWithTCCheckbox() {
        TestHelper.driver.findElement(By.xpath(xpathTCCheckbox)).click();
    }
    public static void submitRegistration() {
        TestHelper.moveToXpathElement(xpathButtonSubmitRegistration);
        TestHelper.waitXpathElement(xpathButtonSubmitRegistration).click();
    }
    public static void verifyThatAccountIsCreated() {
        TestHelper.waitXpathElement(xpathAfterRegistrationSentEmailPopUp);
    }

    public static void verifyFirstNameErrorMessage() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter First Name.",
                    TestHelper.waitXpathElement(xpathFirstNameErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un nombre y apellido válidos.",
                    TestHelper.waitXpathElement(xpathFirstNameErrorMessage).getText());
        }
    }
    public static void verifyLastNameErrorMessage() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter Last Name.",
                    TestHelper.waitXpathElement(xpathLastNameErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un nombre y apellido válidos.",
                    TestHelper.waitXpathElement(xpathLastNameErrorMessage).getText());
        }
    }
    public static void verifyEmailErrorMessage() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid email address.",
                    TestHelper.waitXpathElement(xpathEmailErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un correo electrónico válido.",
                    TestHelper.waitXpathElement(xpathEmailErrorMessage).getText());
        }
    }
    public static void verifyPasswordErrorMessage() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid password containing at least 8 characters with 1 uppercase letter and 1 number.",
                    TestHelper.waitXpathElement(xpathPasswordErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Tu contraseña debe tener 8 caracteres, una mayúscula y un número.",
                    TestHelper.waitXpathElement(xpathPasswordErrorMessage).getText());
        }
    }
    public static void verifyPasswordConfirmationErrorMessage() {
        TestHelper.waitXpathElement(xpathInputConfirmedPassword).click();
        TestHelper.driver.findElement(By.xpath(xpathRadiobuttonGender)).click();
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid password containing at least 8 characters with 1 uppercase letter and 1 number.",
                    TestHelper.waitXpathElement(xpathVerifyPasswordErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Tu contraseña debe tener 8 caracteres, una mayúscula y un número.",
                    TestHelper.waitXpathElement(xpathVerifyPasswordErrorMessage).getText());
        }
    }
    public static void verifyErrorMessageForNotDefinedDateOfBirth() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter your date of birth.", TestHelper.waitXpathElement(xpathDateOfBirthErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Necesitamos tu fecha de nacimiento (Es solo para asegurarnos que tienes más de 18 años).",
                    TestHelper.waitXpathElement(xpathDateOfBirthErrorMessage).getText());
        }
    }
    public static void verifyErrorMessageForNotDefinedGender() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please select Gender.",
                    TestHelper.waitXpathElement(xpathGenderErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Por favor seleccione el género.",
                    TestHelper.waitXpathElement(xpathGenderErrorMessage).getText());
        }
    }
    public static void verifyErrorMessageForNotCheckedTCCheckbox() {
        if (TestHelper.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please read and agree with the Terms and Conditions.",
                    TestHelper.waitXpathElement(xpathTCErrorMessage).getText());
        } else if (TestHelper.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Debes aceptar los términos y condiciones para poder registrarte.",
                    TestHelper.waitXpathElement(xpathTCErrorMessage).getText());
        }
    }

    public static void verifyCompletionOfRegistration() {
        TestHelper.waitXpathElement("//*[@class='row registration-successful-dialog']");
    }
}
