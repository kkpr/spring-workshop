package com.tli.amin.user;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.tli.amin.model.BaseEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author KrishnaPrasad
 *
 */
@Entity
@Table(name="USER_PROFILE")
public class UserProfile extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2233376931908016052L;

	@Column(name="TYPE", length=15, unique=true, nullable=false)
	private String type = UserProfileType.USER.getUserProfileType();
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserProfile))
			return false;
		UserProfile other = (UserProfile) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + getId() + ", type=" + type + "]";
	}

}
