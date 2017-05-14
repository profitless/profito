package by.kanarski.profito.services.impl;

import by.kanarski.profito.dao.interfaces.catalog.ICompanyDao;
import by.kanarski.profito.dao.interfaces.IExtendedBaseDao;
import by.kanarski.profito.dto.CompanyDto;
import by.kanarski.profito.entities.registry.Company;
import by.kanarski.profito.services.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
public class CompanyService extends BaseService<CompanyDto, Company> implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    protected IExtendedBaseDao<Company> getDao() {
        return companyDao;
    }
}
