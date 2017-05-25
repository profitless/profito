package by.kanarski.profito.validation;


import by.kanarski.profito.dto.user.FirstUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, FirstUserDto> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final FirstUserDto user, final ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getPasswordConfirmation());
    }

}
