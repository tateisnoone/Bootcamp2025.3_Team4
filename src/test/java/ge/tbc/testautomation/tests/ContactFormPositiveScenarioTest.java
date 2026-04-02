package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.UsersDbDataProvider;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.BASE_URL;

public class ContactFormPositiveScenarioTest extends BaseTest {
    @AfterMethod(alwaysRun = true)
    public void setupMethod() {
        page.navigate(BASE_URL);
        CookieUtils.acceptIfVisible(page);
        new NavigationFlows(commonSteps, view).openCardsFromHome();
    }

    @Test(
            description = "Validate submit button enabled for DB users",
            dataProvider = "usersDBCases",
            dataProviderClass = UsersDbDataProvider.class
    )
    public void submitButtonShouldBeEnabledForValidUsers(
            String name,
            String personal,
            String phone
    ) {
        cardsSteps.navigateToErtguliCreditCardPage();

        ertguliCreditCardSteps
                .openCardOrderForm()
                .pasteNameAndSurname(name)
                .pastePersonalNumber(personal)
                .pastePhoneNumber(phone)
                .assertSubmitButtonIsEnabled();
    }
}
