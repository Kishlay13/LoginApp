package com.org.leap.finance.LoginApi;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class BaseClass {
	private RestTemplate restTemplate;

	
	public BaseClass() {
		
		this.restTemplate = new RestTemplate();
	}

}
