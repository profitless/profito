package by.kanarski.profito.services.impl;

import by.kanarski.profito.dao.interfaces.catalog.IUserFunctionDao;
import by.kanarski.profito.dao.interfaces.catalog.IUserStatusDao;
import by.kanarski.profito.dao.interfaces.handbook.IPasswordResetTokenDao;
import by.kanarski.profito.dao.interfaces.handbook.IVerificationTokenDao;
import by.kanarski.profito.dao.interfaces.registry.IUserDao;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class UserServiceHelper {

    private IUserDao userDao;
    private IUserFunctionDao userFunctionDao;
    private IUserStatusDao userStatusDao;
    private IVerificationTokenDao verificationTokenDao;
    private IPasswordResetTokenDao passwordResetTokenDao;


    public UserServiceHelper(IUserDao userDao, IUserFunctionDao userFunctionDao, IUserStatusDao userStatusDao,
                             IVerificationTokenDao verificationTokenDao, IPasswordResetTokenDao passwordResetTokenDao) {
        this.userDao = userDao;
        this.userFunctionDao = userFunctionDao;
        this.userStatusDao = userStatusDao;
        this.verificationTokenDao = verificationTokenDao;
        this.passwordResetTokenDao = passwordResetTokenDao;
    }
}
