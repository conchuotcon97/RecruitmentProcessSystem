package com.cdweb.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.User;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User loadUserByUsername(final String username) {
		List<User> users = new ArrayList<User>();
		Session session = this.sessionFactory.getCurrentSession();
		users = session.createQuery("from user where username=?", User.class).setParameter(0, username).list();
		if (users.size() > 0) {
			System.out.println(users.get(0).getUsername() + " " + users.get(0).getPassword());
			return users.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword) {
		Session session = sessionFactory.getCurrentSession();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
		boolean b = (BCrypt.checkpw(oldPassword, user.getPassword()));
		if (b) {
			if (newPassword.equals(confirmNewPassword) && newPassword.length() >= 6) {
				String bCryptPassword = BCrypt.hashpw(confirmNewPassword, BCrypt.gensalt());
				user.setPassword(bCryptPassword);
				session.update(user);
				return true;
			}
		}
		return false;
	}

	@Transactional
	public User profile(String fullName, String email, String avatar, Date birthday, String phone, String address) {
		Session session = sessionFactory.getCurrentSession();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
		user.setFullName(fullName);
		user.setEmail(email);
		user.setAvatar(avatar);
		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setAddress(address);
		System.out.println(user.getFullName());
		session.update(user);
		return user;
		
	}
}
