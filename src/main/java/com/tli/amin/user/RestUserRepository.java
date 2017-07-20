package com.tli.amin.user;

import com.tli.amin.user.domain.RestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RestUserRepository extends JpaRepository<RestUser,Long>{

    User findByUuid(String uuid);
    User findByEmailAddress(String emailAddress);
	@Query("select u from RestUser u where u in (select user from AuthorizationToken where lastUpdated < ?)")
    List<RestUser> findByExpiredSession(Date lastUpdated);

	@Query("select u from RestUser u where u = (select user from AuthorizationToken where token = ?)")
	RestUser findBySession(String token);
}
