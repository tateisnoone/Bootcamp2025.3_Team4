package ge.tbc.testautomation.uitests;

import ge.tbc.testautomation.data.FakerDataGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnonymousTipTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        mainSteps
                .AnonTipPage()
                .clickTbcAnonPage();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void fillAnonymousTipInfo() {
        anonymousTipSteps
                .clickOnStayAnonymous()
                .inputEmail(FakerDataGenerator.randomEmail())
                .selectLocation();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void submitIncidentDetails() {
        anonymousTipSteps
                .clickOnIncidents(5)
                .inputDetails(FakerDataGenerator.randomSentence())
                .submit()
                .submissionValidation();
    }
}