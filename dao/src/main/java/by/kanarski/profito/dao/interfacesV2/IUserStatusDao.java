package by.kanarski.profito.dao.interfacesV2;

import by.kanarski.profito.entities.catalog.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserStatusDao extends JpaRepository<UserStatus, Integer> {

    UserStatus getByUserStatusName(String userStatusName);

}
