package by.kanarski.profito.services.impl;

import by.kanarski.profito.constants.UserUtils;
import by.kanarski.profito.dao.interfacesV2.IUserDao;
import by.kanarski.profito.dao.interfacesV2.IUserFunctionDao;
import by.kanarski.profito.dao.interfacesV2.IUserStatusDao;
import by.kanarski.profito.dao.interfacesV2.IVerificationTokenDao;
import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.entities.catalog.UserFunction;
import by.kanarski.profito.entities.handbook.VerificationToken;
import by.kanarski.profito.entities.registry.User;
import by.kanarski.profito.services.interfaces.IFirstUserService;
import by.kanarski.profito.utils.TokenGenerator;
import by.kanarski.profito.utils.convert.service.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class FirstUserService implements IFirstUserService {

    public static final String TOKEN_INVALID = "token invalid";
    public static final String TOKEN_EXPIRED = "token expired";
    public static final String TOKEN_VALID = "token valid";

    private ModelMapperWrapper modelMapper;
    private IUserDao userDao;
    private IUserFunctionDao userFunctionDao;
    private IUserStatusDao userStatusDao;
    private IVerificationTokenDao verificationTokenDao;
    private PasswordEncoder passwordEncoder;
    private TokenGenerator tokenGenerator;

    @Autowired
    public FirstUserService(ModelMapperWrapper modelMapper, IUserDao userDao, IUserFunctionDao userFunctionDao,
                            IUserStatusDao userStatusDao, IVerificationTokenDao verificationTokenDao,
                            PasswordEncoder passwordEncoder, TokenGenerator tokenGenerator) {
        this.modelMapper = modelMapper;
        this.userDao = userDao;
        this.userFunctionDao = userFunctionDao;
        this.userStatusDao = userStatusDao;
        this.verificationTokenDao = verificationTokenDao;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public String registerUser(final FirstUserDto firstUserDto) {
        final String passwordHash = passwordEncoder.encode(firstUserDto.getPassword());
        final User newUser = modelMapper.map(firstUserDto, User.class);
        newUser
                .setUserPassword(passwordHash)
                .setUserFunctionSet(new HashSet<UserFunction>() {
                    {
                       add(userFunctionDao.getByUserFunctionName(UserUtils.ROLE_SIMPLE_USER));
                    }
                })
                .setUserStatus(userStatusDao.getByUserStatusName(UserUtils.STATUS_UNACTIVATED))
                .setUserIsLocked(false);
        userDao.save(newUser);
        final String tokenValue = tokenGenerator.getUUID();
        VerificationToken verificationToken = new VerificationToken(tokenValue);
        verificationToken.setUser(newUser);
        verificationTokenDao.save(verificationToken);
        return tokenValue;
    }

    @Override
    public String activateUser(final String activationKey) {
        final VerificationToken verificationToken = verificationTokenDao.getByTokenValue(activationKey);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }
        final long currentDateAsLong = new Date().getTime();
        final boolean isTokenExpired = (verificationToken.getTokenExpiryDate().getTime() - currentDateAsLong) < 0;
        if (isTokenExpired) {
            return TOKEN_EXPIRED;
        }
        final User user = verificationToken.getUser();
        verificationTokenDao.delete(verificationToken);
        user.setVerificationToken(null);
        user.setUserStatus(userStatusDao.getByUserStatusName(UserUtils.STATUS_ACTIVATED));
        userDao.save(user);
        return TOKEN_VALID;
    }

}
