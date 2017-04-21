package by.kanarski.gksolutions.services.interfaces;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.UserStatus;

/**
 * Language service interface
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IStatusService extends IBaseService<UserStatus, StatusDto> {

    UserStatus findByStatusName(String statusName);

}
