package by.kanarski.profito.utils.convert.support;


import by.kanarski.profito.dto.StatusDto;
import by.kanarski.profito.entities.catalog.UserStatus;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusDtoToStatusConverter extends EntityConverter<StatusDto, UserStatus> {

    @Override
    public UserStatus convert(StatusDto statusDto) {
//        Integer stateId = statusDto.getStatusId();
//        String stateName = statusDto.getStatusName();
//        return UserStatus.builder().statusId(stateId).statusName(stateName).build();
        return new UserStatus();
    }
}