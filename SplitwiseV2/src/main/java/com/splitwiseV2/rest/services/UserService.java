package main.java.com.splitwiseV2.rest.services;

import main.java.com.splitwiseV2.pojo.User;

public class UserService {
	public int addUser(User user) {
		user.save();
		return user.getId();
	}
}
