package com.cdweb.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cdweb.entity.User;
import com.cdweb.service.MyUserDetailsService;
import com.cdweb.service.UserService;

@Component

public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;
	@Autowired
	private MyUserDetailsService myUserDetailsSerive;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
//		UserDetails principal = myUserDetailsSerive.loadUserByUsername(username);
//		User principal= userService.loadUserByUsername(username);
//		if (principal != null) {
//	return	new UsernamePasswordAuthenticationToken(principal, principal.getPassword(),
//					principal.getAuthorities());
//		}
//
//		else {
//			throw new BadCredentialsException("Authentication failed");
//		}
		UserDetails userDetails = null;
		System.out.println(username);
		User dbUser = userService.loadUserByUsername(username);
		System.out.println(dbUser);
		Authentication result;
		userDetails = new org.springframework.security.core.userdetails.User(dbUser.getUsername(), dbUser.getPassword(), true,
				true, true, true, dbUser.getAuthorities());
		// login xac thuc user

		if (userDetails != null && userDetails.getUsername().equals(username) && userDetails.getPassword().equals(password)) {
			return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
					userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException("External system authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
