package by.kanarski.profito.services.interfaces;

import by.kanarski.profito.dto.user.FirstUserDto;

/**
 * The interface First user service.
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IFirstUserService {

    /**
     * Register first user.
     *
     * @param firstUserDto the first user dto
     * @return the mail confirmation id
     */
    String registerUser(FirstUserDto firstUserDto);

    String activateUser(String activationKey);

}

