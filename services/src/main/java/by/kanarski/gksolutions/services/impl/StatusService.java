package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.IStatusDao;
import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.UserStatus;
import by.kanarski.gksolutions.services.interfaces.IStatusService;
import by.kanarski.gksolutions.utils.criteria.Restrictions;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StatusService extends BaseService<UserStatus, StatusDto> implements IStatusService {

    @Autowired
    private IStatusDao statusDao;

    public UserStatus findByStatusName(String statusName) {
        SearchFilter searchFilter = new SearchFilter()
                .addRestriction(Restrictions.eq(UserStatus.Fields.statusName.name(), statusName));
        return statusDao.getUniqueByFilter(searchFilter);
    }

    @Override
    protected IExtendedBaseDao<UserStatus> getDao() {
        return this.statusDao;
    }
}