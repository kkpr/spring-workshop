package com.tli.amin.user;

import java.util.Date;
import java.util.List;

import com.tli.amin.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

	User findBySsoId(String sso);

	void deleteBySsoId(String sso);

	User findByEmail(String email);

}

