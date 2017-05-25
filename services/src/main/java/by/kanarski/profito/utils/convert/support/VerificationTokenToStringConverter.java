package by.kanarski.profito.utils.convert.support;

import by.kanarski.profito.entities.handbook.VerificationToken;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class VerificationTokenToStringConverter extends EntityConverter<VerificationToken, String> {

    @Override
    protected String convert(VerificationToken source) {
        return source.getTokenValue();
    }
}
