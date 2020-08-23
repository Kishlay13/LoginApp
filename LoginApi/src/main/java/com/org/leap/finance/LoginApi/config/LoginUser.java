package com.org.leap.finance.LoginApi.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.leap.finance.LoginApi.model.User;

public class LoginUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4609368347238457707L;
	private String userName;
	private String password;
	private long userId;

	public LoginUser(User user) {

		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.userId = user.getId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {

		return password;
	}

	public long getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
