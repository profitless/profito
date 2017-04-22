package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.catalog.UserStatus;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusToStatusDtoConverter extends EntityConverter<UserStatus, StatusDto> {

    @Override
    public StatusDto convert(UserStatus userStatus) {
        Integer stateId = userStatus.getId();
        String stateName = userStatus.getUserStatusName();
        return StatusDto.builder().statusId(stateId).statusName(stateName).build();
    }
}
