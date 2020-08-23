package com.org.leap.finance.LoginApi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseContent {

	private String url;
	private byte[] resource;
}
