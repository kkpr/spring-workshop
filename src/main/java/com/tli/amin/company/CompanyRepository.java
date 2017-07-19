package com.tli.amin.company;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByCompanyName(String name);
}
