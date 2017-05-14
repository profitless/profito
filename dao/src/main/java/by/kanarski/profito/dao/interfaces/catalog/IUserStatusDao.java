package by.kanarski.profito.dao.interfaces.catalog;

import by.kanarski.profito.dao.interfaces.IBaseDao;
import by.kanarski.profito.dao.interfaces.IExtendedBaseDao;
import by.kanarski.profito.entities.catalog.UserStatus;

/**
 * Language dao iterface
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 * @see IBaseDao
 */
public interface IUserStatusDao extends IExtendedBaseDao<UserStatus> {

    /**
     * Gets user status by status name.
     *
     * @param userStatusName the user status name
     * @return user status
     */
    UserStatus getByStatusName(String userStatusName);

}
