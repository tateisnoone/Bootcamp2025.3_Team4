package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.NegativeUsersDataProvider;
import org.testng.annotations.Test;

public class ContactFormTests extends BaseTest{

    @Test(dataProvider = "invalidNameData", dataProviderClass = NegativeUsersDataProvider.class)
    public void validateInvalidName(String inputValue, String expectedError) {
        cardsSteps.navigateToErtguliCreditCardPage();
        ertguliCreditCardSteps
                .openCardOrderForm()
                .typeNameAndSurname(inputValue)
                .assertErrorMessageIsVisible(expectedError);
    }

    @Test(dataProvider = "invalidPersonalNumberData", dataProviderClass = NegativeUsersDataProvider.class)
    public void validateInvalidPersonalNumber(String inputValue, String expectedError) {
        ertguliCreditCardSteps
                .typePersonalNumber(inputValue)
                .assertErrorMessageIsVisible(expectedError);
    }

    @Test(dataProvider = "invalidPhoneData", dataProviderClass = NegativeUsersDataProvider.class)
    public void validateInvalidPhone(String inputValue, String expectedError) {
        ertguliCreditCardSteps
                .typePhoneNumber(inputValue)
                .assertErrorMessageIsVisible(expectedError);
    }
}
