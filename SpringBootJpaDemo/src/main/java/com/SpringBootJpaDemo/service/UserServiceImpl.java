package com.SpringBootJpaDemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootJpaDemo.dao.UserRepository;
import com.SpringBootJpaDemo.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public List<User> readAllUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Transactional
	@Override
	public User findByuseridAnduserName(Integer userid, String userName) {

		return userRepository.findByUseridAndUserName(userid, userName);
	}

	@Transactional
	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User updateUser(User user1, int userId) {

		Optional<User> userdata = userRepository.findById(userId);
		if (userdata.isPresent()) {
			User user = userdata.get();
			user.setUserName(user1.getUserName());
			user.setPassword(user1.getPassword());
			return userRepository.save(user);
		} else {
			return userRepository.save(user1);
		}
	}

	@Transactional
	@Override
	public void deleteUser(int userId) {

		userRepository.deleteById(userId);
	}
}
