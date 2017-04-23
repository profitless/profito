package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageDao extends ExtendedBaseDao<Language> implements IExtendedBaseDao<Language> {

    @Autowired
    public LanguageDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
