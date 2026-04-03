package ge.tbc.testautomation.data;

import ge.tbc.testautomation.config.DataBaseConfig;
import ge.tbc.testautomation.models.Users;
import org.testng.annotations.DataProvider;

import java.util.List;

public class UsersDbDataProvider {

    @DataProvider(name = "usersDBCases", parallel = true)
    public static Object[][] usersDBCases() {
        List<Users> cases = DataBaseConfig.dbMapper().selectAllUsers();
        Object[][] data = new Object[cases.size()][3];

        for (int i = 0; i < cases.size(); i++) {
            Users user = cases.get(i);
            data[i][0] = user.getFullName();
            data[i][1] = user.getPersonalId();
            data[i][2] = user.getPhoneNumber();
        }

        return data;
    }
}