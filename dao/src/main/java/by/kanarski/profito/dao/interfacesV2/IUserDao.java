package by.kanarski.profito.dao.interfacesV2;

import by.kanarski.profito.entities.registry.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserDao extends JpaRepository<User, Integer> {
}
