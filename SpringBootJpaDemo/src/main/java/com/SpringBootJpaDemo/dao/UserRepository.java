package com.SpringBootJpaDemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootJpaDemo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUseridAndUserName(Integer userid, String userName);
}
	
