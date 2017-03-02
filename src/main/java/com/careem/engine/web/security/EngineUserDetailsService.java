package com.careem.engine.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EngineUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String loggedUser = "", loggedUserPassword = "";
		Long userId = null;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		UserDetails userDetails = new EngineUserDetails(loggedUser,
				loggedUserPassword, Boolean.TRUE, Boolean.TRUE,
				Boolean.TRUE,
				Boolean.TRUE, authorities, userId);
		
		return userDetails;
	}
}