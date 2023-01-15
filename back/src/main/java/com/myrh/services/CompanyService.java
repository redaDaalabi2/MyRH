package com.myrh.services;

import com.myrh.utils.Enum;
import com.myrh.models.Company;
import com.myrh.repositories.CompanyRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Repository
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public List<Company> listAll(){
        return companyRepository.findAll();
    }

    public UserDetails findByEmail(String login){
        Company company = companyRepository.findAll()
                .stream()
                .filter(c -> (c.getLogin()).equals(login))
                .findFirst()
                .orElse(null);
        return company != null ? new User(
                company.getLogin(),
                company.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(Enum.role.COMPANY.toString()))) : null ;
    }

    public Company getCompanyByLogin(String login){
        return companyRepository.findByLogin(login);
    }
}
