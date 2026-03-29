package ge.tbc.testautomation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Long id;
    private String fullName, personalId, phoneNumber;
}
