package by.kanarski.profito.dto.user;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Very simple user dto, which is used to register the first user
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
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
