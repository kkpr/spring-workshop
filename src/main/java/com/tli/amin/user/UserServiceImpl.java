package com.tli.amin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	public User findBySSO(String sso) {
		User user = userRepository.findBySsoId(sso);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = userRepository.findOne(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		userRepository.deleteBySsoId(sso);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public boolean isUserSSOUnique(Long id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
