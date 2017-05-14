package by.kanarski.profito.dao.impl.handbook;

import by.kanarski.profito.dao.impl.ExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.handbook.IVerificationTokenDao;
import by.kanarski.profito.entities.handbook.VerificationToken;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class VerificationTokenDao extends ExtendedBaseDao<VerificationToken> implements IVerificationTokenDao {

}
