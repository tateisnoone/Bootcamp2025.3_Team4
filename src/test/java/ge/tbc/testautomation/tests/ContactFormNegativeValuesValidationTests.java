package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.FieldType;
import ge.tbc.testautomation.data.InputClassifier;
import ge.tbc.testautomation.data.ErtguliFormUsersDataProvider;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.*;

public class ContactFormNegativeValuesValidationTests extends BaseTest{

    @AfterMethod(alwaysRun = true)
    public void setupMethod() {
        page.navigate(BASE_URL);
        CookieUtils.acceptIfVisible(page);
        new NavigationFlows(commonSteps, view).openCardsFromHome();
    }

    @Test(dataProvider = "invalidFormData", dataProviderClass = ErtguliFormUsersDataProvider.class)
    public void validateInvalidInput(String value) {

        FieldType type = InputClassifier.resolve(value);

        cardsSteps.navigateToErtguliCreditCardPage();

        ertguliCreditCardSteps.openCardOrderForm();

        switch (type) {

            case NAME -> ertguliCreditCardSteps
                    .typeNameAndSurname(value)
                    .assertErrorMessageIsVisible(ERROR_NAME_AND_SURNAME_TXT);

            case PERSONAL -> ertguliCreditCardSteps
                    .typePersonalNumber(value)
                    .assertErrorMessageIsVisible(ERROR_PERSONAL_NUMBER_TXT);

            case PHONE -> ertguliCreditCardSteps
                    .typePhoneNumber(value)
                    .assertErrorMessageIsVisible(ERROR_PHONE_NUMBER_TXT);
        }
    }

    @Test(dataProvider = "invalidFullFormData", dataProviderClass = ErtguliFormUsersDataProvider.class)
    public void validateMultipleInvalidFields(String name, String personal, String phone) {
        cardsSteps.navigateToErtguliCreditCardPage();

        ertguliCreditCardSteps
                .openCardOrderForm()
                .typeNameAndSurname(name)
                .typePersonalNumber(personal)
                .typePhoneNumber(phone)
                .assertErrorMessageIsVisible(ERROR_NAME_AND_SURNAME_TXT)
                .assertErrorMessageIsVisible(ERROR_PERSONAL_NUMBER_TXT)
                .assertErrorMessageIsVisible(ERROR_PHONE_NUMBER_TXT);
    }
}
