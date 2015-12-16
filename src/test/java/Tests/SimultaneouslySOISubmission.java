package Tests;

import Common.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by AVilshinsky on 16.12.2015.
 */
public class SimultaneouslySOISubmission {


    @BeforeClass
    public static void precondition() {

    }
    @Before
    public void setUp() {
        TestHelper.droneDriver("chrome");
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Test
    public void firstThread() {

    }

    @Test
    public void secondThread() {

    }

    @Test
    public void thirdThread() {

    }
}
