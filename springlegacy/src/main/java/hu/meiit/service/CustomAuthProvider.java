package hu.meiit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userService;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		UserDetails username = userService.loadUserByUsername(auth.getPrincipal().toString());
		System.out.println(auth.getPrincipal().toString());
		if (username == null) {
			return null;
		}
		if (username.getUsername().equals(username.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, username.getPassword(), username.getAuthorities());
		}
		return null;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
