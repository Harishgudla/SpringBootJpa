package com.SpringBootJpaDemo.service;

import java.util.List;

import com.SpringBootJpaDemo.model.User;

public interface UserService {
	public abstract List<User> readAllUsers();
	public abstract User findByuseridAnduserName(Integer userid, String userName);
	public abstract User createUser(User user);
	public abstract User updateUser(User user,int userId);
	public abstract void deleteUser(int userId);
}
