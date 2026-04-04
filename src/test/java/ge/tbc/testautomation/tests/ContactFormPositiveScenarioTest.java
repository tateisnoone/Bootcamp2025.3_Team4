package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.UsersDbDataProvider;
import ge.tbc.testautomation.utils.RetryCount;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"Ertguli Card Contact Form - Submit button is activated after entering valid data T4-T6"})
public class ContactFormPositiveScenarioTest extends BaseTest {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        cardsSteps.navigateToErtguliCreditCardPage();
        ertguliCreditCardSteps.openCardOrderForm();
    }

    @RetryCount(count = 3)
    @Test(description = "Validate submit button enabled for DB users", dataProvider = "usersDBCases",
            dataProviderClass = UsersDbDataProvider.class)
    public void submitButtonShouldBeEnabledForValidUsers(String name, String personal, String phone) {
        ertguliCreditCardSteps
                .pasteNameAndSurname(name)
                .pastePersonalNumber(personal)
                .pastePhoneNumber(phone)
                .assertSubmitButtonIsEnabled();
    }

    @AfterMethod
    public void clearFields() {
        ertguliCreditCardSteps.clearNameAndSurnameInput()
                .clearPersonalNumberInput()
                .clearPhoneNumberInput();
    }
}
