package com.cdweb.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.UserDAO;
import com.cdweb.entity.User;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword){
		return userDAO.changePassword(oldPassword, newPassword, confirmNewPassword);
	}
	
	public User loadUserByUsername(final String username){
		return userDAO.loadUserByUsername(username);
	}
	
	public User profile(String fullName, String email, String avatar, Date birthday, String phone, String address) {
		return userDAO.profile(fullName, email, avatar, birthday, phone, address);
	}
}
