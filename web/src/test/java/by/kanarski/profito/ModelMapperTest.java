package by.kanarski.profito;

import by.kanarski.profito.config.ServicesConfig;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServicesConfig.class})
public class ModelMapperTest extends Assert {

//    private ModelMapperWrapper modelMapperWrapper;
//    private PhoneUtils phoneUtils;
//
//    private FirstUserDto firstUserDtoMock;
//    private User firstUser;
//
//    @Autowired
//    public ModelMapperTest(ModelMapperWrapper modelMapperWrapper, PhoneUtils phoneUtils) {
//        this.modelMapperWrapper = modelMapperWrapper;
//        this.phoneUtils = phoneUtils;
//    }
//
//    @Before
//    public void setUp() {
//        firstUserDtoMock = FirstUserDto.builder().email("someemail@gmail.com").password("password")
//                .passwordConfirmation("password").firstName("Василий").lastName("Иванович")
//                .mobilePhone("+375-29-202-63-84").workPhone("+375-17-213-41-43").skype("someSkype")
//                .build();
//        firstUser = User.builder().userEmail(firstUserDtoMock.getEmail()).userPassword(firstUserDtoMock.getPassword())
//                .userFirstName(firstUserDtoMock.getFirstName()).userLastName(firstUserDtoMock.getLastName())
//                .phoneSet(new HashSet<Phone>() {
//                    {
//                        add(phoneUtils.buildPhone(firstUserDtoMock.getWorkPhone(), PhoneUtils.WORK_PHONE));
//                        add(phoneUtils.buildPhone(firstUserDtoMock.getMobilePhone(), PhoneUtils.MOBILE_PHONE));
//                    }
//                })
//                .userSkype(firstUserDtoMock.getSkype())
//                .build();
//    }
//
//    @Test
//    public void firstUserDtoToUserConverterTest() throws Exception {
//        User expected = modelMapperWrapper.map(firstUserDtoMock, User.class);
//        assertEquals(expected, firstUser);
//    }

}
