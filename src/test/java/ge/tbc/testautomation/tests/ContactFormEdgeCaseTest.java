package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.ErtguliFormUsersDataProvider;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.*;

public class ContactFormEdgeCaseTest extends BaseTest{

    @Test(dataProvider = "validPastedFullFormData", dataProviderClass = ErtguliFormUsersDataProvider.class)
    public void fillFormData(String name, String personal, String phone) {
        cardsSteps.navigateToErtguliCreditCardPage();

        ertguliCreditCardSteps
                .openCardOrderForm()
                .pasteNameAndSurname(name)
                .pastePersonalNumber(personal)
                .pastePhoneNumber(phone)
                .assertErrorMessageIsVisible(ERROR_PHONE_NUMBER_WHEN_FORMATTING_CHARACTERS_TXT);
    }
}