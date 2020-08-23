package com.org.leap.finance.LoginApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Url {
	@JsonProperty("url")
	private String url;

}
