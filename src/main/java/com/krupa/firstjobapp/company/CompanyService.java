package com.krupa.firstjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Long id,Company company);

    void createCompnay(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}
