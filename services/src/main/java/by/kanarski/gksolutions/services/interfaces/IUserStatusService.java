package by.kanarski.gksolutions.services.interfaces;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.catalog.UserStatus;

/**
 * Language service interface
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IUserStatusService extends IBaseService<UserStatus, StatusDto> {

    UserStatus findByStatusName(String statusName);

}
