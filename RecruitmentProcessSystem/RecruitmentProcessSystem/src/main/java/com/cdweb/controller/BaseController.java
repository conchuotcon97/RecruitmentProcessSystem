package com.cdweb.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class BaseController {

	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session) {
		return Collections.singletonMap("token", session.getId());
	}

//	@RequestMapping("/user")
//	public Principal user(HttpServletRequest request,Principal user) {
//		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//	return()->new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	
		
//	}
	
	 @RequestMapping("/user")
	  public Principal user(Principal user) {
		 System.out.println("principal.getname:   "+user.getName()+ "  role"+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
	    return user;
	  }

	

}
