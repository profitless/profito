package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dao.interfaces.catalog.IUserStatusDao;
import by.kanarski.gksolutions.entities.catalog.UserStatus;
import by.kanarski.gksolutions.utils.criteria.Restrictions;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StringToStatusConverter extends EntityConverter<String, UserStatus> {

    @Override
    public UserStatus convert(String source) {
        IUserStatusDao statusDao = applicationContext.getBean(IUserStatusDao.class);
        SearchFilter searchFilter = new SearchFilter()
                .addRestriction(Restrictions.eq(UserStatus.Fields.statusName.name(), source));
        return statusDao.getUniqueByFilter(searchFilter);
    }
}
