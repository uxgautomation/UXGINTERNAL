package PageObjects;

import Common.TestHelper;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ReviewPage {
    public static String xpathReviewInReviews = "//a[contains(@href,'/story')]";
    public static String xpathFirstStar = "//i[contains(@class,'vp_star-star_1')]";
    public static String xpathSecondStar = "//i[contains(@class,'vp_star-star_2')]";
    public static String xpathThirdStar = "//i[contains(@class,'vp_star-star_3')]";
    public static String xpathFourthStar = "//i[contains(@class,'vp_star-star_4')]";
    public static String xpathFifthStar = "//i[contains(@class,'vp_star-star_5')]";
    public static String xpathButtonNextOrGoBack = "//input[@type='submit']";
    public static String xpathTextareaReview = "//textarea";
    public static String xpathButtonSubmitReview = "//input[contains(@class,'submit-my-review')]";
    public static String xpathTextReview = "//*[contains(@class,'comment')]/*[contains(@class,'wl-review-answer')]";

    public static String xpathNoRateErrorMessage = "//*[contains(@class,'status-message')]/div[text()]";
    public static String xpathNoTextErrorMessage = "//*[contains(@class,'status-message') and text()]";

    @Step
    public static void setRate() {
        TestHelper.waitXpathElement(xpathFirstStar).click();
    }
    @Step
    public static void clickOnNextButton() {
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).isDisplayed();
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).isEnabled();
        TestHelper.waitSec(1);
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).click();
    }
    @Step
    public static void fillInTextarea() {
        TestHelper.waitXpathElement(xpathTextareaReview).sendKeys("Selenium review body text.");
    }
    @Step
    public static void clickOnSubmitMyReviewButton() {
        TestHelper.waitXpathElement(xpathButtonSubmitReview).click();
    }
    @Step
    public static void verifyThatReviewIsAdded() {
        Assert.assertEquals("Selenium review body text.", TestHelper.waitXpathElement(xpathTextReview).getText());
    }

    @Step
    public static void verifyThatNoRateErrorMessageIsDisplayed() {
        Assert.assertEquals(true, TestHelper.waitXpathElement(xpathNoRateErrorMessage).isDisplayed());
    }

    @Step
    public static void verifyThatNoTextErrorMessageIsDisplayed() {
        Assert.assertEquals(true, TestHelper.waitXpathElement(xpathNoTextErrorMessage).isDisplayed());
    }

}
