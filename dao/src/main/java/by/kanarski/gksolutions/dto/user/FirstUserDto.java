package by.kanarski.gksolutions.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirstUserDto implements Serializable {

    private static final long serialVersionUID = 4151799960482680421L;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String fatherName;
    private String lastName;
    private String skype;
    private String workPhone;
    private String mobilePhone;

}
