package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.ErtguliFormUsersDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.*;

@Test(groups = {"Ertguli Card Contact Form - Invalid inputs should not be allowed T4-T2"})
public class ContactFormNegativeValuesValidationTests extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        cardsSteps.navigateToErtguliCreditCardPage();
        ertguliCreditCardSteps.openCardOrderForm();
    }

    @Test(dataProvider = "invalidFullFormData", dataProviderClass = ErtguliFormUsersDataProvider.class)
    public void validateMultipleInvalidFields(String name, String personal, String phone) {
        ertguliCreditCardSteps
                .typeNameAndSurname(name)
                .typePersonalNumber(personal)
                .typePhoneNumber(phone)
                .assertErrorMessageIsVisible(ERROR_NAME_AND_SURNAME_TXT)
                .assertErrorMessageIsVisible(ERROR_PERSONAL_NUMBER_TXT)
                .assertErrorMessageIsVisible(ERROR_PHONE_NUMBER_TXT);
    }

    @AfterMethod
    public void clearFields() {
        ertguliCreditCardSteps.clearNameAndSurnameInput()
                .clearPersonalNumberInput()
                .clearPhoneNumberInput();
    }
}
