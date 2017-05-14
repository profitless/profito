package by.kanarski.profito.dao.interfaces.catalog;

import by.kanarski.profito.dao.interfaces.IExtendedBaseDao;
import by.kanarski.profito.entities.catalog.UserFunction;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserFunctionDao extends IExtendedBaseDao<UserFunction> {

    UserFunction getByName(String userFunctionName);

}
