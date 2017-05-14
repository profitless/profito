package by.kanarski.profito.dao.impl.catalog;

import by.kanarski.profito.dao.impl.ExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.catalog.IUserStatusDao;
import by.kanarski.profito.entities.catalog.UserStatus;
import org.springframework.stereotype.Repository;

@Repository
public class UserStatusDao extends ExtendedBaseDao<UserStatus> implements IUserStatusDao {

    private static final String GET_BY_NAME_QUERY =
            "select us FROM UserStatus us where us.userStatusName = ?";

    @Override
    public UserStatus getByStatusName(String userStatusName) {
        return (UserStatus) getSession().createQuery(GET_BY_NAME_QUERY)
                .setParameter(0, userStatusName)
                .uniqueResult();
    }

}
