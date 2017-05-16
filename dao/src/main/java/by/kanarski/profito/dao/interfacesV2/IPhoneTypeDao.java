package by.kanarski.profito.dao.interfacesV2;

import by.kanarski.profito.entities.catalog.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IPhoneTypeDao extends JpaRepository<PhoneType, Integer> {

    public PhoneType getByPhoneTypeName(String phoneTypeName);

}
