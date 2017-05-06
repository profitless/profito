package by.kanarski.gksolutions;

import by.kanarski.gksolutions.config.ServicesApplication;
import by.kanarski.gksolutions.constants.PhoneTypes;
import by.kanarski.gksolutions.dto.user.FirstUserDto;
import by.kanarski.gksolutions.entities.handbook.Phone;
import by.kanarski.gksolutions.entities.registry.User;
import by.kanarski.gksolutions.utils.convert.service.ModelMapperWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServicesApplication.class})
public class ModelMapperTest extends Assert {

    @Autowired
    private ModelMapperWrapper modelMapperWrapper;

    private FirstUserDto firstUserDtoMock;
    private User firstUser;

    @Before
    public void setUp() {
        firstUserDtoMock = FirstUserDto.builder().email("someemail@gmail.com").password("password")
                .passwordConfirmation("password").firstName("Василий").lastName("Иванович")
                .mobilePhone("+375-29-202-63-84").workPhone("+375-17-213-41-43").skype("someSkype")
                .build();
        firstUser = User.builder().userEmail(firstUserDtoMock.getEmail()).userPassword(firstUserDtoMock.getPassword())
                .userFirstName(firstUserDtoMock.getFirstName()).userLastName(firstUserDtoMock.getLastName())
                .phoneSet(new HashSet<Phone>() {
                    {
                        add(Phone.newInstance(firstUserDtoMock.getWorkPhone(), PhoneTypes.WORK));
                        add(Phone.newInstance(firstUserDtoMock.getMobilePhone(), PhoneTypes.MOBILE));
                    }
                })
                .skype(firstUserDtoMock.getSkype())
                .build();
    }

    @Test
    public void firstUserDtoToUserConverterTest() throws Exception {
        User expected = modelMapperWrapper.map(firstUserDtoMock, User.class);
        assertEquals(expected, firstUser);
    }

}
