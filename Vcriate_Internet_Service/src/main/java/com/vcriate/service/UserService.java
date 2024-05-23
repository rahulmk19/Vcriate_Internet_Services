package com.vcriate.service;

import java.util.List;

import com.vcriate.exception.VcriateException;
import com.vcriate.model.User;

public interface UserService {

	public User UpdateUser(long id, User user);

	public String CancelUser(Long userId);

	public List<User> ShowAllUser();

	User register(User user);

	User findByUsername(String username) throws VcriateException;

	User findByname(String name) throws VcriateException;

}
