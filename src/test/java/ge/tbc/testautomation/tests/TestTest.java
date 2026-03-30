package ge.tbc.testautomation.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("API Integration")
@Feature("Cards Page Validation")
public class TestTest extends BaseTest {

    @Test(priority = 1)
    @Description("Validate CTA title from API matches UI.")
    public void validateCtaTitleApiVsUi() {
       commonSteps.goToHome();
    }
    @Test(priority = 2)
    public void failureTest() {
        Assert.assertTrue(false, "Test failure for Allure");
    }


}
