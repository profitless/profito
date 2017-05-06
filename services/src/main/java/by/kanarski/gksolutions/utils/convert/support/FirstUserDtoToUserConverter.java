package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.constants.PhoneTypes;
import by.kanarski.gksolutions.dto.user.FirstUserDto;
import by.kanarski.gksolutions.entities.handbook.Phone;
import by.kanarski.gksolutions.entities.registry.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class FirstUserDtoToUserConverter extends EntityConverter<FirstUserDto, User> {

    @Override
    public User convert(FirstUserDto userDto) {
        User user = getMapper().map(userDto, User.class);
        user.setPhoneSet(new HashSet<Phone>() {
            {
                add(Phone.newInstance(userDto.getWorkPhone(), PhoneTypes.WORK));
                add(Phone.newInstance(userDto.getMobilePhone(), PhoneTypes.MOBILE));
            }
        });
        return user;
    }
}
