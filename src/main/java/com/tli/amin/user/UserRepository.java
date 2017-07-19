package com.tli.amin.user;

import java.util.Date;
import java.util.List;

import com.tli.amin.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

	User findBySsoId(String sso);

	void deleteBySsoId(String sso);

	User findByEmailAddress(String emailAddress);

	@Query("select u from User u where uuid = ?")
	User findByUuid(String uuid);

	@Query("select u from User u where u in (select user from AuthorizationToken where lastUpdated < ?)")
	List<User> findByExpiredSession(Date lastUpdated);

	@Query("select u from User u where u = (select user from AuthorizationToken where token = ?)")
	User findBySession(String token);
}

