package PageObjects;

import Common.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {
    public static String xpathButtonRegistration = "//*[@class='wl-unreg-user-menu']/a[2]";
    public static String xpathButtonLogin = "//*[@class='wl-unreg-user-menu']/a[1]";

    public static String xpathUserAvatar = "//*[contains(@class,'user-picture')]";
    public static String xpathButtonMyProfile = "//a[contains(@href,'.com/profile/')]";

    public static String xpathLinksSocialOnFooter = "//a[contains(@class,'social-btn')]";

    public static String xpathButtonHamburger = "//a[contains(@class,'bt-menu-trigger')]";

    public static void clickOnRegisterButton() {
        TestHelper.waitXpathElement(HomePage.xpathButtonRegistration).click();
    }

    public static void clickOnLogInButton() {
        TestHelper.waitXpathElement(HomePage.xpathButtonLogin).click();
    }

    public static void goToMyProfile() {
        TestHelper.waitXpathElement(HomePage.xpathButtonMyProfile).click();
    }

    public static void verifyThatFooterHaveEightSocialButtons() {
        Assert.assertEquals(8,TestHelper.driver.findElements(By.xpath(xpathLinksSocialOnFooter)).size());
    }

    public static void verifyThatHamburgerButtonIsExist() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonHamburger).isEnabled());
    }
}
