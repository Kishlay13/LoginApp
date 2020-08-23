package com.org.leap.finance.LoginApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ControllerTest extends BaseClass {

	public static String LOGINAPI = "http://localhost:8080/login";

	
	private TestRestTemplate restTemplate;
	public ControllerTest() {
		super();
		this.restTemplate = new TestRestTemplate();
	}

	@Test
	public void testLogin() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("abcd", "defg");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(LOGINAPI, HttpMethod.GET, entity, String.class);
		assertEquals(response.getStatusCode(), "200");

	}
	@Test
	public void testLogin_neagtive() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("123", "defg");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(LOGINAPI, HttpMethod.GET, entity, String.class);
		assertEquals(response.getStatusCode(), "200");

	}

	

}
