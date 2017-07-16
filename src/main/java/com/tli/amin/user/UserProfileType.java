package com.tli.amin.user;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
