package com.org.leap.finance.LoginApi.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.leap.finance.LoginApi.model.Content;
import com.org.leap.finance.LoginApi.model.User;
import com.org.leap.finance.LoginApi.repositories.UrlRepository;
import com.org.leap.finance.LoginApi.repositories.UserRepository;

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Autowired
	private UserRepository userRepository;

	public void saveUrl(User user, String url, byte[] resource) {
		Content urlSaved = new Content();
		urlSaved.setUrl(url);
		urlSaved.setUser(user);
		urlSaved.setResource(resource);
		urlRepository.save(urlSaved);

	}

	public List<Content> getUrlsForUserId(long user_id) {
		/*
		 * List<Url> urls = new ArrayList<>(); Optional<Url> url =
		 * urlRepository.findAllByUserId(user_id); if (url.isPresent()) { url.map(u ->
		 * urls.add(u)); }
		 */
		return urlRepository.findAllByUserId(user_id);

	}

}
