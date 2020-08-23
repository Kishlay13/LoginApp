package com.org.leap.finance.LoginApi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.org.leap.finance.LoginApi.service.LoginUserDetailsService;

@EnableWebSecurity
public class LoginConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private LoginUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("").authoritiesByUsernameQuery("");
		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder getPassword() {

		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
		 * .antMatchers("/api/v1/*").hasRole("USER").and().httpBasic();
		 */
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
