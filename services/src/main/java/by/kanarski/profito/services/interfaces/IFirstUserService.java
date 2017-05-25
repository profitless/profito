package by.kanarski.profito.services.interfaces;

import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.dto.user.ConfirmationUser;

/**
 * The interface First user service.
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IFirstUserService {

    ConfirmationUser registerUser(FirstUserDto firstUserDto);

    String activateUser(String activationKey);

}

