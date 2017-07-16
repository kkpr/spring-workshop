package com.tli.amin.user;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by KrishnaPrasad on 16/07/2017.
 */
public interface PersistentLoginRepository extends JpaRepository<PersistentLogin,String> {

    PersistentLogin getBySeries(String seriesId);
    PersistentLogin findByUsername(String username);
}
