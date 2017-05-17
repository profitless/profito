package by.kanarski.profito.utils.convert.support;

import by.kanarski.profito.entities.catalog.UserStatus;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StringToStatusConverter extends EntityConverter<String, UserStatus> {

    @Override
    public UserStatus convert(String source) {
//        IUserStatusDao statusDao = applicationContext.getBean(IUserStatusDao.class);
//        SearchFilter searchFilter = new SearchFilter()
//                .addRestriction(Restrictions.eq(UserStatus.Fields.statusName.name(), source));
//        return statusDao.getUniqueByFilter(searchFilter);
        return new UserStatus();
    }
}
