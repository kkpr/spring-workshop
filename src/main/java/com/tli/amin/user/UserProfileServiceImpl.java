package com.tli.amin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tli.amin.user.UserProfileRepository;
import com.tli.amin.user.UserProfile;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public UserProfile findById(int id) {
		return userProfileRepository.findOne(id);
	}

	public UserProfile findByType(String type){
		return userProfileRepository.findByType(type);
	}

	public List<UserProfile> findAll() {
		return userProfileRepository.findAll();
	}
}
