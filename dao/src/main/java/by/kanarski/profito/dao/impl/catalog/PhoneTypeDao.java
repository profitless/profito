package by.kanarski.profito.dao.impl.catalog;

import by.kanarski.profito.dao.impl.ExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.catalog.IPhoneTypeDao;
import by.kanarski.profito.entities.catalog.PhoneType;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class PhoneTypeDao extends ExtendedBaseDao<PhoneType> implements IPhoneTypeDao {
}
