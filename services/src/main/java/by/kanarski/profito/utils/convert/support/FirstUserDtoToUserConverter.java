package by.kanarski.profito.utils.convert.support;

import by.kanarski.profito.constants.PhoneUtils;
import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.entities.handbook.Phone;
import by.kanarski.profito.entities.registry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class FirstUserDtoToUserConverter extends EntityConverter<FirstUserDto, User> {

    private PhoneUtils phoneUtils;

    @Autowired
    public FirstUserDtoToUserConverter(PhoneUtils phoneUtils) {
        this.phoneUtils = phoneUtils;
    }

    @Override
    public User convert(FirstUserDto firstUserDto) {
        User user = getMapper().defaultMapper().map(firstUserDto, User.class);
        user.setPhoneSet(new HashSet<Phone>() {
            {
                add(phoneUtils.buildPhone(firstUserDto.getWorkPhone(), PhoneUtils.WORK_PHONE));
                add(phoneUtils.buildPhone(firstUserDto.getMobilePhone(), PhoneUtils.MOBILE_PHONE));
            }
        });
        return user;
    }

}
