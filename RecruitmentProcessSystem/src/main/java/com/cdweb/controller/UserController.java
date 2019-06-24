package com.cdweb.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.User;
import com.cdweb.service.UserService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(path = "hr/changePasswordHR", method = RequestMethod.POST)
	public String changePasswordHR(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		return "changePasswordHR";
	}

	@RequestMapping("/hr/changePasswordHR")
	public String userChangePasswordHR() {
		return "changePasswordHR";
	}

	@RequestMapping("/hr/hr")
	public String loadUserByUsernameHR(@ModelAttribute User user, ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "hr";
	}

	@PutMapping("/users/{id}")

	public User profile(@PathVariable(value = "id") int id, @RequestBody User user) {
		User profile = userService.findById(id);
		profile.setAddress(user.getAddress());
		profile.setAvatar(user.getAvatar());
		profile.setBirthday(user.getBirthday());
		profile.setFullName(user.getFullName());
		profile.setEmail(user.getEmail());
		profile.setGender(user.isGender());
		profile.setPhone(user.getPhone());

		return userService.profile(profile);
	}

	// admin
	@RequestMapping(path = "admin/changePasswordAdmin", method = RequestMethod.POST)
	public String changePasswordAdmin(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		return "changePasswordHR";
	}

	@RequestMapping("admin/changePasswordAdmin")
	public String userChangePasswordAdmin() {
		return "changePasswordHR";
	}

	@RequestMapping("admin/admin")
	public String loadUserByUsernameAdmin(@ModelAttribute User user, ModelMap modelMap) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "admin";
	}

//	@PostMapping("admin/admin")
//	public String profileAdmin(@ModelAttribute User user, @RequestParam String fullName, @RequestParam String email,
//			@RequestParam String avatar, @RequestParam Date birthday, @RequestParam String phone,
//			@RequestParam String address, ModelMap modelMap) {
//		user = userService.profile(fullName, email, avatar, birthday, phone, address);
//		modelMap.addAttribute("user", user);
//		System.out.println(user.getFullName());
//		return "admin";
//	}

	// interviewer
	@RequestMapping(path = "changePasswordInterviewer", method = RequestMethod.POST)
	public String changePasswordInterviewer(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		return "changePasswordHR";
	}

	@RequestMapping("changePasswordInterviewer")
	public String userChangePasswordInterviewer() {
		return "changePasswordHR";
	}

	@RequestMapping("interviewer")
	public String loadUserByUsernameInterviewer(@ModelAttribute User user, ModelMap modelMap) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "interviewer";
	}

//	@PostMapping("interviewer")
//	public String profileInterviewer(@ModelAttribute User user, @RequestParam String fullName,
//			@RequestParam String email, @RequestParam String avatar, @RequestParam Date birthday,
//			@RequestParam String phone, @RequestParam String address, ModelMap modelMap) {
//		user = userService.profile(fullName, email, avatar, birthday, phone, address);
//		modelMap.addAttribute("user", user);
//		System.out.println(user.getFullName());
//		return "interviewer";
//	}
}
