package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

import static ge.tbc.testautomation.Constants.*;

public class NegativeUsersDataProvider {
    @DataProvider(name = "invalidNameData")
    public static Object[][] invalidNameData() {
        return new Object[][] {
                {"DexterMorganS4EP12", ERROR_NAME_AND_SURNAME_TXT},
        };
    }

    @DataProvider(name = "invalidPersonalNumberData")
    public static Object[][] invalidPersonalNumberData() {
        return new Object[][] {
                {"7777", ERROR_PERSONAL_NUMBER_TXT},
        };
    }

    @DataProvider(name = "invalidPhoneData")
    public static Object[][] invalidPhoneData() {
        return new Object[][] {
                {"571", ERROR_PHONE_NUMBER_TXT},
        };
    }
}
