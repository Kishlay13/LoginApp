package com.org.leap.finance.LoginApi.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.text.Utilities;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.leap.finance.LoginApi.Util.Utilies;
import com.org.leap.finance.LoginApi.config.LoginUser;
import com.org.leap.finance.LoginApi.model.Content;
import com.org.leap.finance.LoginApi.model.ResponseContent;
import com.org.leap.finance.LoginApi.model.Url;
import com.org.leap.finance.LoginApi.model.User;
import com.org.leap.finance.LoginApi.repositories.UrlRepository;
import com.org.leap.finance.LoginApi.service.UrlService;
import com.org.leap.finance.LoginApi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {

	@Autowired
	private UrlService urlService;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	private String loginApi() {
		return "<h1>Welcome Home User</h1?";

	}

	@GetMapping("/login")
	private String loginApiReturned() {
		return "<h1>Welcome </h1?";

	}

	@PostMapping("/api/v1/save")
	public ResponseEntity<Void> saveContent(@RequestBody Url url) throws IOException {
		LoginUser principal = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		URL urlIn = new URL(url.getUrl());
		URLConnection conn = urlIn.openConnection();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(conn.getInputStream(), baos);
		User user = userService.getUser(principal.getUserId());
		log.debug("saving Url " + url.getUrl() + " for user " + user.getUserName());
		urlService.saveUrl(user, url.getUrl(), baos.toByteArray());
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@GetMapping("/api/v1/fetch/{user_id}")
	public ResponseEntity<List<ResponseContent>> fetchContent(@PathVariable("user_id") long user_id) {
		log.debug("fetching URL and corresponding resources for user id :" + user_id);
		return new ResponseEntity<List<ResponseContent>>(
				Utilies.convertDbToResponse(urlService.getUrlsForUserId(user_id)), HttpStatus.OK);

	}

}
