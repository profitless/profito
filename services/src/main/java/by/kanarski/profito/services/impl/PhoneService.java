package by.kanarski.profito.services.impl;

import by.kanarski.profito.dao.interfaces.IExtendedBaseDao;
import by.kanarski.profito.dao.interfaces.handbook.IPhoneDao;
import by.kanarski.profito.dto.PhoneDto;
import by.kanarski.profito.entities.handbook.Phone;
import by.kanarski.profito.services.interfaces.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PhoneService extends BaseService<PhoneDto, Phone> implements IPhoneService {

    @Autowired
    private IPhoneDao phoneDao;

    @Override
    protected IExtendedBaseDao<Phone> getDao() {
        return phoneDao;
    }
}
