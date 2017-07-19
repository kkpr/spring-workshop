package com.tli.amin.user;

import com.tli.amin.company.Company;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
public class CompanyUsers {
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
