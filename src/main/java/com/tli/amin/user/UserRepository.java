package com.tli.amin.user;

import java.util.List;

import com.tli.amin.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findBySsoId(String sso);

	void deleteBySsoId(String sso);
}

