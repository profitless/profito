package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.registry.IUserDao;
import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.registry.User;
import by.kanarski.gksolutions.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserService extends BaseService<User, UserDto> implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * Recives user DTO with status active by email
     *
     * @param email user email
     * @return required user DTO
     */
    @Override
    public UserDto getByEmail(String email) {
        return null;
    }

    /**
     * Checks whether a user with given credentials in the database
     *
     * @param userDto user DTO, that contains required credentials
     * @return true, if with same credentials exist, else false
     */
    @Override
    public boolean isNewUser(UserDto userDto) {
        return false;
    }

    /**
     * Adds user into database
     *
     * @param userDto an user to addRestriction
     */
    @Override
    public void registerUser(UserDto userDto) {

    }

    @Override
    protected IExtendedBaseDao<User> getDao() {
        return userDao;
    }
}
