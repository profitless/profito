package by.kanarski.profito.dao.impl.handbook;

import by.kanarski.profito.dao.impl.ExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.handbook.IPasswordResetTokenDao;
import by.kanarski.profito.entities.handbook.PasswordResetToken;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class PasswordResetTokenDao extends ExtendedBaseDao<PasswordResetToken> implements IPasswordResetTokenDao {
}
