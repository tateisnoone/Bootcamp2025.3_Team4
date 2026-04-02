package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class ErtguliFormUsersDataProvider {
    @DataProvider(name = "invalidFormData")
    public static Object[][] invalidFormData() {
        return new Object[][] {
                {"DexterMorganS4EP12"},
                {"BrianMoserS1EP12"},
                {"7777"},
                {"9999"},
                {"571"},
                {"1098547109755"}
        };
    }

    @DataProvider(name = "invalidFullFormData")
    public static Object[][] invalidFullFormData() {
        return new Object[][] {
                {"DexterDidItellYouThatImissyous0ng", "7777", "571"},
                {"DexterMorganS4EP12", "0293", "1098547109755"}
        };
    }

    @DataProvider(name = "validPastedFullFormData")
    public static Object[][] validPastedFullFormData(){
        return new Object[][] {
                {"სახელი გვარი", "01001111111", "597-00-00-00"}
        };
    }
}
