package ge.tbc.testautomation.db;

import ge.tbc.testautomation.models.Users;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UsersMapper {
    @Select("""
        SELECT ID as id,
               FULL_NAME as fullName,
               PERSONAL_ID as personalId,
               PHONE_NUMBER as phoneNumber
        FROM USERS
    """)
    List<Users> selectAllUsers();
}
