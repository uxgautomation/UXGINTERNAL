package Tests;

import Common.TestHelper;
import PageObjects.*;
import Common.Environments;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestsSmoke {
    @BeforeClass
    public static void setPrecondition() {
        TestHelper.droneDriver("firefox");
        TestHelper.setFullscreen();
        Environments.createMailBox();
        Environments.passRegistration();
        TestHelper.quit();
    }
    @Before
    public void setUp() {
        TestHelper.droneDriver("firefox");
        TestHelper.setFullscreen();
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Test
    public void userShouldBeAbleToLogIn() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin(Environments.emailValue + "@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
        AuthorizationPage.verifyWelcomeMessage();
    }

    @Test
    public void a_shouldBeAbleToAddCommentInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.fillTextAreaByComment();
        ArticlePage.clickOnPostMyCommentButton();
        ArticlePage.verifyThatCommentIsAdded();
    }

    @Test
    public void b_shouldSeeLeftCommentsInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToCommentsSection();
        ProfilePage.verifyThatCommentInSectionIsDisplayed();
    }

    @Test
    public void c_shouldBeAbleDeleteCommentInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToCommentsSection();
        ProfilePage.deleteComment();
        ProfilePage.confirmDeleteComment();
        ProfilePage.verifyThatCommentIsDeleted();
    }

    @Test
    public void a_shouldBeAbleToAddLoveInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.loveArticle();
        ArticlePage.verifyThatLovesCounterIsIncreased();
    }

    @Test
    public void b_shouldBeAbleToDeleteLoveInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.unLoveArticle();
        ArticlePage.verifyThatLovesCounterIsDecreased();
    }

    @Test
    public void c_shouldSeeLovesInProfile() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.loveArticle();
        HomePage.goToMyProfile();
        ProfilePage.goToLovesSection();
        ProfilePage.verifyLoveInLovesSection();
    }

    @Test
    public void d_shouldBeAbleToDeleteLoveInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToLovesSection();
        ProfilePage.deleteLoveInProfile();
        ProfilePage.confirmDeleteLove();
        ProfilePage.verifyLoveDeleted();
    }

    @Test
    public void unauthorizedUserShouldBeRedirectedToAuthorizationWhenAddLove() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.loveArticleUnauthorized();
        ArticlePage.verifyRedirectionToLogInAfterTryToAddLove();
    }

    @Test
    public void unauthorizedUserShouldNotBeAbleWriteCommentsInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.verifyInabilityToLeaveCommentsByUnauthorizedUser();
    }

    @Test
    public void unauthorizedUserShouldSeeLogInAndRegisterButtonInsteadCommentBlock() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.verifyAvailabilityOfSignInAndRegisterButtonsInsteadCommentsBlock();
    }

    @Test
    public void shouldSeeErrorMessagesInRegistrationFormWhenLeftFirstNameEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyFirstNameErrorMessage();

    }
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftLastNameEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyLastNameErrorMessage();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftEmailEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyEmailErrorMessage();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftPasswordEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyPasswordErrorMessage();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftVerifiedPasswordEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.verifyPasswordConfirmationErrorMessage();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenDateOfBirthNotDefined() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedDateOfBirth();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenGenderNotDefined() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedDateOfBirth();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenTCCheckboxNotAgreed() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedGender();
    }

    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenConfirmationPasswordIsFailed() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotCheckedTCCheckbox();
    }

    @Test
    public void shouldStayAtArticleAfterLogInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.verifyThatCurrentPageIsArticle();
    }

    @Test
    public void shouldBeAbleToEditBio() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.fillInBioTextArea();
        ProfilePage.submitBioChanges();
        ProfilePage.verifyThatChangesInProfileIsAppeared();
    }

    @Test
    public void shouldSeeWelcomeMessageInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatWelcomeMessageInProfileIsAppeared();
    }

    @Test
    public void shouldSeeSignViaFacebookButton() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.verifyAvailabilityOfFacebookButton();
    }

    @Test
    public void shouldSeeForgotYourPasswordLink() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.verifyAvailabilityOfForgorPasswordLink();
    }

    @Test
    public void shouldSeeEightSocialButtonsOnFooter() {
        Environments.goTo(Environments.BASE_URL);
        TestHelper.scrollPage(1500);
        HomePage.verifyThatFooterHaveEightSocialButtons();
    }

    @Test
    public void shouldSeeHamburgerButton() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.verifyThatHamburgerButtonIsExist();
    }

    @Test
    public void shouldConnectFacebookButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectFacebookEnabled();
    }

    @Test
    public void shouldConnectTwitterButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectTwitterEnabled();
    }

    @Test
    public void shouldConnectBlogButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectBlogEnabled();
    }

    @Test
    public void shouldBeAbleToLeftReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.fillInTextarea();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatReviewIsAdded();
    }

    @Test
    public void shouldSeeErrorMessageWhenNoStarsSetInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.clickOnNextButton();
        ReviewPage.verifyThatNoRateErrorMessageIsDisplayed();
    }

    @Test
    public void shouldSeeErrorMessageWhenNoTextInTextarea() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatNoTextErrorMessageIsDisplayed();
    }
}
