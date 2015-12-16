package Tests;

import Common.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimultaneouslySOISubmission {

    public static String first = "0";
    public static String second = "0";
    public static String third = "0";

    @Before
    public void setUp() {
        TestHelper.runDriver("chrome");
        TestHelper.setFullscreen();
        TestHelper.get("https://test2.vocalpoint.com/campaigns/autotest0001/consumer-facing-sample-opt-name/1?page-1");
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Test
    public void firstThread() {
        TestHelper.waitXpathElement("//*[@class='wl-unreg-user-menu']/a[1]").click();
        TestHelper.waitXpathElement("//*[@id='edit-name']").sendKeys("20151210112512@mailforspam.com");
        TestHelper.waitXpathElement("//*[@id='edit-pass']").sendKeys("Uxgpassword1");
        TestHelper.waitXpathElement("//*[@id='edit-submit']").click();
        TestHelper.waitXpathElement("//*[contains(@class,'wl-user-menu')]//*[contains(@class,'user-picture')]");
        TestHelper.waitXpathElement("//input[@type='submit']").isEnabled();
        TestHelper.waitXpathElement("//input[@type='submit']").click();
        TestHelper.waitXpathElement("//input[contains(@class,'first-name')]");
        for(int i=0;i<3000;i++) {
            if(TestHelper.waitXpathElement("//input[@type='submit']").isDisplayed()
                    && TestHelper.waitXpathElement("//input[@type='submit']").isEnabled()) {
                first = "1";
                break;
            }
            TestHelper.waitMsec(100);
        }
        for(int i=0;i<3000;i++) {
            if(first.equals("1") && second.equals("1") && third.equals("1") ) {
                TestHelper.waitXpathElement("//input[@type='submit']").click();
                break;
            }
            TestHelper.waitMsec(100);
        }
        TestHelper.waitXpathElement("//*[@class='soi-share']");
        System.out.println(TestHelper.waitXpathElement("//h6").getText());
    }

    @Test
    public void secondThread() {
        TestHelper.waitXpathElement("//*[@class='wl-unreg-user-menu']/a[1]").click();
        TestHelper.waitXpathElement("//*[@id='edit-name']").sendKeys("20151210130625@mailforspam.com");
        TestHelper.waitXpathElement("//*[@id='edit-pass']").sendKeys("Uxgpassword1");
        TestHelper.waitXpathElement("//*[@id='edit-submit']").click();
        TestHelper.waitXpathElement("//*[contains(@class,'wl-user-menu')]//*[contains(@class,'user-picture')]");
        TestHelper.waitXpathElement("//input[@type='submit']").isEnabled();
        TestHelper.waitXpathElement("//input[@type='submit']").click();
        TestHelper.waitXpathElement("//input[contains(@class,'first-name')]");
        for(int i=0;i<3000;i++) {
            if(TestHelper.waitXpathElement("//input[@type='submit']").isDisplayed()
                    && TestHelper.waitXpathElement("//input[@type='submit']").isEnabled()) {
                second = "1";
                break;
            }
            TestHelper.waitMsec(100);
        }
        for(int i=0;i<3000;i++) {
            if(first.equals("1") && second.equals("1") && third.equals("1") ) {
                TestHelper.waitXpathElement("//input[@type='submit']").click();
                break;
            }
            TestHelper.waitMsec(100);
        }
        TestHelper.waitXpathElement("//*[@class='soi-share']");
        System.out.println(TestHelper.waitXpathElement("//h6").getText());
    }

    @Test
    public void thirdThread() {
        TestHelper.waitXpathElement("//*[@class='wl-unreg-user-menu']/a[1]").click();
        TestHelper.waitXpathElement("//*[@id='edit-name']").sendKeys("20151211105952@mailforspam.com");
        TestHelper.waitXpathElement("//*[@id='edit-pass']").sendKeys("Uxgpassword1");
        TestHelper.waitXpathElement("//*[@id='edit-submit']").click();
        TestHelper.waitXpathElement("//*[contains(@class,'wl-user-menu')]//*[contains(@class,'user-picture')]");
        TestHelper.waitXpathElement("//input[@type='submit']").isEnabled();
        TestHelper.waitXpathElement("//input[@type='submit']").click();
        TestHelper.waitXpathElement("//input[contains(@class,'first-name')]");
        for(int i=0;i<3000;i++) {
            if(TestHelper.waitXpathElement("//input[@type='submit']").isDisplayed()
                    && TestHelper.waitXpathElement("//input[@type='submit']").isEnabled()) {
                third = "1";
                break;
            }
            TestHelper.waitMsec(100);
        }
        for(int i=0;i<3000;i++) {
            if(first.equals("1") && second.equals("1") && third.equals("1") ) {
                TestHelper.waitXpathElement("//input[@type='submit']").click();
                break;
            }
            TestHelper.waitMsec(100);
        }
        TestHelper.waitXpathElement("//*[@class='soi-share']");
        System.out.println(TestHelper.waitXpathElement("//h6").getText());
    }
}