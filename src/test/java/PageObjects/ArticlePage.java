package PageObjects;

import Common.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ArticlePage {
    public static String xpathTextAreaComment = "//textarea[contains(@class,'form-textarea')]";
    public static String xpathButtonPostComment = "//*[@class='wl-upload-media-submit']//input[@type='submit']";
    public static String xpathComment = "//*[@class='users-comment']//a[contains(@class,'username')]";
    public static String xpathButtonLoveArticle = "//a[contains(@href,'/node/')]";
    public static String xpathLovesCounter = "//a[contains(@href,'/node/')]/following-sibling::p/span[contains(@content,'UserLikes')]";
    public static String xpathButtonUnLoveArticle = "//a[contains(@href,'/node/')][contains(@href,'/unlike')]";

    public static String xpathTitlesArticle = "//*[@itemprop='name']";

    public static String xpathLoveUnauthorized = "//*[contains(@class,'wl-article-page-content')]//a[contains(@class,'like-btn')]";
    public static String xpathCommentsBlockUnauthorized = "//*[contains(@class,'wl-comments-auth')]";
    public static String xpathCommentsBlockLoginUnauthorized = "//*[contains(@class,'wl-comments-auth')]/a[contains(@href,'/login')]";
    public static String xpathCommentsBlockRegisterUnauthorized = "//*[contains(@class,'wl-comments-auth')]/a[contains(@href,'/register')]";


    public static void fillTextAreaByComment() {
        TestHelper.waitXpathElement(xpathTextAreaComment).sendKeys("Selenium autotest comment.");
    }
    public static void clickOnPostMyCommentButton() {
        TestHelper.waitXpathElement(xpathButtonPostComment).click();
    }
    public static void verifyThatCommentIsAdded() {
        TestHelper.waitXpathElement(xpathComment);
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathComment).isDisplayed());
    }

    public static int initialLoveCounter = 0;
    public static int finalLoveCounter = 0;
    public static int getLoveState() {
        int intCounter = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounter).getText());
        return intCounter;
    }
    public static void loveArticle() {
        initialLoveCounter = getLoveState();
        TestHelper.waitXpathElement(xpathButtonLoveArticle).click();
        TestHelper.waitSec(1);
    }
    public static void unLoveArticle() {
        initialLoveCounter = getLoveState();
        TestHelper.waitXpathElement(xpathButtonUnLoveArticle).click();
        TestHelper.waitSec(1);
    }

    public static void verifyThatLovesCounterIsIncreased() {
        finalLoveCounter = getLoveState();
        System.out.println("Should increase. Loves before: " + initialLoveCounter + " Loves after: " + finalLoveCounter);
        Assert.assertEquals(initialLoveCounter + 1,finalLoveCounter);
    }

    public static void verifyThatLovesCounterIsDecreased() {
        getLoveState();
        finalLoveCounter = getLoveState();
        System.out.println("Should decrease. Loves before: " + initialLoveCounter + " Loves after: " + finalLoveCounter);
        Assert.assertEquals(initialLoveCounter - 1,finalLoveCounter);
    }

    public static void verifyThatCurrentPageIsArticle() {
        TestHelper.waitXpathElement(HomePage.xpathButtonMyProfile);
        Assert.assertEquals("Selenium Article",TestHelper.driver.findElement(By.xpath(xpathTitlesArticle)).getText());
    }

    public static void loveArticleUnauthorized() {
        TestHelper.waitXpathElement(xpathLoveUnauthorized).click();
        TestHelper.waitSec(1);
    }
    public static void verifyRedirectionToLogInAfterTryToAddLove() {
        TestHelper.waitXpathElement(AuthorizationPage.xpathInputLogin);
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(AuthorizationPage.xpathInputLogin)).isDisplayed());
    }

    public static void verifyInabilityToLeaveCommentsByUnauthorizedUser() {
        TestHelper.waitXpathElement(xpathCommentsBlockUnauthorized);
        Assert.assertEquals(true,TestHelper.waitXpathElementNotExist(xpathTextAreaComment));
    }

    public static void verifyAvailabilityOfSignInAndRegisterButtonsInsteadCommentsBlock() {
        TestHelper.waitXpathElement(xpathCommentsBlockUnauthorized);
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(xpathCommentsBlockLoginUnauthorized)).isDisplayed());
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(xpathCommentsBlockRegisterUnauthorized)).isDisplayed());
    }
}
