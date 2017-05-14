package by.kanarski.profito.dao.impl;

import by.kanarski.profito.dao.interfaces.catalog.ICompanyDao;
import by.kanarski.profito.entities.registry.Company;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class CompanyDao extends ExtendedBaseDao<Company> implements ICompanyDao {

}
