package by.kanarski.profito.constants;

import by.kanarski.profito.dao.interfacesV2.IPhoneTypeDao;
import by.kanarski.profito.entities.handbook.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class PhoneUtils {

    public static final String WORK_PHONE = "WORK";
    public static final String MOBILE_PHONE = "MOBILE";

    private IPhoneTypeDao phoneTypeDao;

    @Autowired
    public PhoneUtils(IPhoneTypeDao phoneTypeDao) {
        this.phoneTypeDao = phoneTypeDao;
    }

    public Phone buildPhone(String phoneNumber, String phoneType) {
        return Phone.builder()
                .phoneNumber(phoneNumber)
                .phoneType(phoneTypeDao.getByPhoneTypeName(phoneType))
                .build();
    }
}
