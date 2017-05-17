package by.kanarski.profito.dto;

import by.kanarski.profito.dto.user.UserDto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@Builder
public class UserDetailsDto implements Serializable {

    private UserDto userDto;

}
