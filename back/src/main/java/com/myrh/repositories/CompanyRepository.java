package com.myrh.repositories;

import com.myrh.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByLogin(String login);
}
