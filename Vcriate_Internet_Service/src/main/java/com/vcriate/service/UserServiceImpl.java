package com.vcriate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vcriate.exception.VcriateException;
import com.vcriate.model.Role;
import com.vcriate.model.User;
import com.vcriate.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder pc ;

    @Override
    public User register(User user) {
    	user.setRole(Role.USER);
    	user.setPassword(pc.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) throws VcriateException {
    	User u = userRepo.findByUsername(username).get();
    	
    	if(u==null) {
    		throw new VcriateException("User not found with username: " + username);
    	}
    	
    	return u;
    }

	@Override
	public User findByname(String name) throws VcriateException {
		
    	User u = userRepo.findByName(name);
    	
    	if(u==null) {
    		throw new VcriateException("User not found with username: " + name);
    	}
    	
    	u.setUsername("");
    	
    	return u;
	}
	

	@Override
	public User UpdateUser(long id, User user) {
		Optional<User> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			return userRepo.save(user);
		} else {
			throw new VcriateException("user not exist");
		}
	}

	@Override
	public String CancelUser(Long userId) {
		Optional<User> opt = userRepo.findById(userId);
		if (opt.isPresent()) {
			userRepo.deleteById(userId);
			return "User Deleted";
		} else {
			throw new VcriateException("user not Exist");
		}

	}

	@Override
	public List<User> ShowAllUser() {
		List<User> allUser = userRepo.findAll();
		if (!allUser.isEmpty()) {
			return allUser;
		} else {
			throw new VcriateException("user Not Found");
		}

	}

}
