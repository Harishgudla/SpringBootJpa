package com.SpringBootJpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootJpaDemo.model.User;
import com.SpringBootJpaDemo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userService.readAllUsers();
	}
	@GetMapping("/getById")
	public User findByUserIdAndUserName(@RequestParam("id") int userid, @RequestParam("name") String userName){
		return userService.findByuseridAnduserName(userid, userName);
	}
	@PutMapping("/updateById")
	public User updateUser(@RequestBody User user,@RequestParam("id") int userId){
		return userService.updateUser(user, userId);
	}
	@PostMapping("/create")
	public User createUser(@RequestBody User user){
		return userService.createUser(user);
	}
	@DeleteMapping("/deleteById")
	public void deleteUser(@RequestParam("id") int userId){
		userService.deleteUser(userId);;
	}
}
