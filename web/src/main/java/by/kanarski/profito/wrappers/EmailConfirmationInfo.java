package by.kanarski.profito.wrappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailConfirmationInfo {

    private String email;
    private String activationKey;
    private Locale locale;

}
