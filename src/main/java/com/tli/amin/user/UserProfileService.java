package com.tli.amin.user;

import java.util.List;

import com.tli.amin.user.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
