package by.kanarski.gksolutions.utils.convert.support;


import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.UserStatus;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusDtoToStatusConverter extends EntityConverter<StatusDto, UserStatus> {

    @Override
    public UserStatus convert(StatusDto statusDto) {
        Integer stateId = statusDto.getStatusId();
        String stateName = statusDto.getStatusName();
        return UserStatus.builder().statusId(stateId).statusName(stateName).build();
    }
}
