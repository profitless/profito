package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.IStatusDao;
import by.kanarski.gksolutions.entities.catalog.UserStatus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDao extends ExtendedBaseDao<UserStatus> implements IStatusDao {

    @Autowired
    public StatusDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
