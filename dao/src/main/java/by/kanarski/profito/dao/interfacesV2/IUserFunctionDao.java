package by.kanarski.profito.dao.interfacesV2;

import by.kanarski.profito.entities.catalog.UserFunction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserFunctionDao extends JpaRepository<UserFunction, Integer> {

    UserFunction getByUserFunctionName(String userFunctionName);

}
