package by.kanarski.profito.dao.impl.catalog;

import by.kanarski.profito.dao.impl.ExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.catalog.IUserFunctionDao;
import by.kanarski.profito.entities.catalog.UserFunction;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class UserFunctionDao extends ExtendedBaseDao<UserFunction> implements IUserFunctionDao {

    private static final String GET_BY_NAME_QUERY =
            "select uf FROM UserFunction uf where uf.userFunctionName = ?";

    @Override
    public UserFunction getByName(String userFunctionName) {
        return (UserFunction) getSession().createQuery(GET_BY_NAME_QUERY)
                .setParameter(0, userFunctionName)
                .uniqueResult();
    }
}
