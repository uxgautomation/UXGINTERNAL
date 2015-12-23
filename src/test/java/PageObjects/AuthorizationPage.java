package PageObjects;

import Common.TestHelper;
import org.junit.Assert;

public class AuthorizationPage {
    public static String xpathInputLogin = "//*[@id='edit-name']";
    public static String xpathInputPassword = "//*[@id='edit-pass']";
    public static String xpathSubmitButton = "//*[@id='edit-submit']";
    public static String xpathButtonFacebookSignIn = "//a[contains(@class,'button-primary facebook')]";
    public static String xpathLinkForgotPassword = "//a[contains(@title,'user/password')]";

    public static void fillInputLogin(String login) {
        TestHelper.waitXpathElement(AuthorizationPage.xpathInputLogin).sendKeys(login);
    }
    public static void fillInputPassword(String password) {
        TestHelper.waitXpathElement(AuthorizationPage.xpathInputPassword).sendKeys(password);
    }
    public static void submitAuthorization() {
        TestHelper.waitXpathElement(AuthorizationPage.xpathSubmitButton).isDisplayed();
        TestHelper.waitXpathElement(AuthorizationPage.xpathSubmitButton).isEnabled();
        TestHelper.waitXpathElement(AuthorizationPage.xpathSubmitButton).click();
        TestHelper.longWaitXpathElement("//*[contains(@class,'wl-user-menu')]//*[contains(@class,'user-picture')]");
    }
    public static void verifyWelcomeMessage() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(HomePage.xpathUserAvatar).isDisplayed());
    }

    public static void verifyAvailabilityOfFacebookButton() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonFacebookSignIn).isEnabled());
    }

    public static void verifyAvailabilityOfForgorPasswordLink() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathLinkForgotPassword).isEnabled());
    }
}
