package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.ErtguliFormUsersDataProvider;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.*;

public class ContactFormEdgeCaseTest extends BaseTest{
    @AfterMethod(alwaysRun = true)
    public void setupMethod() {
        page.navigate(BASE_URL);
        CookieUtils.acceptIfVisible(page);
        new NavigationFlows(commonSteps, view).openCardsFromHome();
    }

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