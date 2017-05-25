package by.kanarski.profito.dto.user;

import by.kanarski.profito.validation.PasswordMatches;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static by.kanarski.profito.validation.ValidationMessages.*;
import static by.kanarski.profito.validation.ValidationRegExps.*;

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

@PasswordMatches(message = PASSWORDS_DONT_MATCH)
public class FirstUserDto implements Serializable {

    private static final long serialVersionUID = 4151799960482680421L;

    @Pattern(regexp = EMAIL_REGEXP, message = EMAIL_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String email;
    @Pattern(regexp = PASSWORD_REGEXP, message = PASSWOROD_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String password;
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String passwordConfirmation;
    @AssertFalse(message = PASSWORDS_DONT_MATCH)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private Boolean isPasswordsEquals;
    @Pattern(regexp = NAME_REGEXP, message = NAME_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String firstName;
    @Pattern(regexp = NAME_REGEXP, message = NAME_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String lastName;
    @Pattern(regexp = NAME_REGEXP, message = NAME_ERROR)
    private String fatherName;
    @Pattern(regexp = PHONE_REGEXP, message = PHONE_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String workPhone;
    @Pattern(regexp = PHONE_REGEXP, message = PHONE_ERROR)
    @NotNull(message = EMPTY_FIELD_ERROR)
    private String mobilePhone;
    @Pattern(regexp = SKYPE_REGEXP, message = SKYPE_ERROR)
    private String skype;

    public boolean isPasswordsEquals() {
        return password.equals(passwordConfirmation);
    }
}
