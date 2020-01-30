package com.galaxe.gst.service.login;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.galaxe.gst.dao.login.LoginDao;
import com.galaxe.gst.models.login.Roles;
import com.galaxe.gst.models.login.Users;

/**
 * 
 * @author naluru
 *
 */
@Service("loginService")
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	LoginDao loginDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Users user = loginDao.findByUserName(username);

		List<GrantedAuthority> authorities = buildUserAuthority(user
				.getUserRole());

		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(Users user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Roles> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Roles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}
