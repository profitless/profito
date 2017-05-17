package by.kanarski.profito.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Simple strings encoder, based on PasswordEncoder
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class TokenGenerator {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public TokenGenerator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encode(String ... baseStrings) {
        Double randomDouble = Math.random();
        String source = StringUtils.join(baseStrings).concat(randomDouble.toString());
        return passwordEncoder.encode(source);
    }

    public String getUUID() {
        return UUID.randomUUID().toString();
    }

}
