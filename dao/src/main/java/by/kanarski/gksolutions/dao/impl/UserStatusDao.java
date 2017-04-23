package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.catalog.IUserStatusDao;
import by.kanarski.gksolutions.entities.catalog.UserStatus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserStatusDao extends ExtendedBaseDao<UserStatus> implements IUserStatusDao {

    @Autowired
    public UserStatusDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
