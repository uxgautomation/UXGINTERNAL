package PageObjects;

import Common.Environments;
import Common.TestHelper;
import org.junit.Assert;

public class ProfilePage {
    public static String xpathLinkToCommentsSection = "//a[contains(@href,'/comments')]";
    public static String xpathCommentInCommentsSection = "//*[contains(text(),'Selenium autotest comment')]";
    public static String xpathButtonDeleteCommentLove = "//a[text()='delete']";
    public static String xpathButtonYesDeleteComment = "//button[text()='Yes']";

    public static String xpathLinkToLovesSection = "//*[@class='vp_tab_loves']";
    public static String xpathLoveInLovesSection = "//*[@class='topic-title']//a";

    public static String xpathBioTextArea = "//*[contains(@class,'edit-bio-wrap')]//textarea";
    public static String xpathButtonBioSubmit = "//*[contains(@class,'edit-bio-wrap')]/input";
    public static String xpathTextBio = "//*[contains(@class,'biography-inner')]/p";

    public static String xpathWelcomeMessageInProfile = "//*[contains(@class,'biography-inner')]//h2";

    public static String xpathButtonConnectFacebook = "//a[contains(@class,'social-btn-connect facebook')]";
    public static String xpathButtonConnectTwitter = "//a[contains(@class,'social-btn-connect twitter')]";
    public static String xpathButtonConnectBlog = "//a[contains(@href,'/blog')]";

    public static int checkpointForPickUpPassword = 0;

    public static void goToCommentsSection() {
        TestHelper.waitXpathElement(xpathLinkToCommentsSection).click();
    }
    public static void verifyThatCommentInSectionIsDisplayed() {
        Assert.assertEquals("Selenium autotest comment.",TestHelper.waitXpathElement(xpathCommentInCommentsSection).getText());
    }

    public static void deleteComment() {
        TestHelper.waitXpathElement(xpathButtonDeleteCommentLove).click();
    }
    public static void confirmDeleteComment() {
        TestHelper.waitMsec(1500);
        TestHelper.waitXpathElement(xpathButtonYesDeleteComment).click();
    }
    public static void verifyThatCommentIsDeleted() {
        Assert.assertEquals(true,TestHelper.waitXpathElementNotExist(xpathCommentInCommentsSection));
    }

    public static void goToLovesSection() {
        TestHelper.waitXpathElement(xpathLinkToLovesSection).click();
    }
    public static void verifyLoveInLovesSection() {
        TestHelper.waitXpathElement(xpathLoveInLovesSection);
        Assert.assertEquals("Selenium Article",TestHelper.waitXpathElement(xpathLoveInLovesSection).getText());
    }

    public static void deleteLoveInProfile() {
        TestHelper.waitXpathElement(xpathButtonDeleteCommentLove).click();
    }
    public static void confirmDeleteLove() {
        TestHelper.waitMsec(1500);
        TestHelper.waitXpathElement(xpathButtonYesDeleteComment).click();
    }
    public static void verifyLoveDeleted() {
        Assert.assertEquals(true,TestHelper.waitXpathElementNotExist(xpathLoveInLovesSection));
    }

    public static void fillInBioTextArea() {
        TestHelper.waitXpathElement(xpathBioTextArea).sendKeys("Some biographical text about user.");
    }
    public static void submitBioChanges() {
        TestHelper.scrollPage(100);
        TestHelper.waitXpathElement(xpathButtonBioSubmit).isDisplayed();
        TestHelper.waitXpathElement(xpathButtonBioSubmit).isEnabled();
        TestHelper.waitXpathElement(xpathButtonBioSubmit).click();
    }
    public static void verifyThatChangesInProfileIsAppeared() {
        Assert.assertEquals("Some biographical text about user.",TestHelper.waitXpathElement(xpathTextBio).getText());
    }

    public static void verifyThatWelcomeMessageInProfileIsAppeared() {
        if(TestHelper.waitXpathElement("//h3[contains(text(),'Hello,')]").isDisplayed()) {
            Assert.assertEquals(Environments.emailValue + " S.",TestHelper.waitXpathElement(xpathWelcomeMessageInProfile).getText().replace("Hi. I'm ",""));
        } else if(TestHelper.waitXpathElement("//h3[contains(text(),'Hola,')]").isDisplayed()) {
            Assert.assertEquals(Environments.emailValue + " S.",TestHelper.waitXpathElement(xpathWelcomeMessageInProfile).getText().replace("Hola, soy ",""));
        }
    }

    public static void verifyThatConnectFacebookEnabled() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonConnectFacebook).isEnabled());
    }

    public static void verifyThatConnectTwitterEnabled() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonConnectTwitter).isEnabled());
    }

    public static void verifyThatConnectBlogEnabled() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonConnectBlog).isEnabled());
    }
}
