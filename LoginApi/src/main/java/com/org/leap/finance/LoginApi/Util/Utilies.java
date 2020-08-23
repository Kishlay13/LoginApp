package com.org.leap.finance.LoginApi.Util;

import java.util.ArrayList;
import java.util.List;

import com.org.leap.finance.LoginApi.model.Content;
import com.org.leap.finance.LoginApi.model.ResponseContent;

public class Utilies {

	public static List<ResponseContent> convertDbToResponse(List<Content> dbContent) {
		List<ResponseContent> responseContentList = new ArrayList<ResponseContent>();
		for (Content c : dbContent) {
			responseContentList.add(ResponseContent.builder().resource(c.getResource()).url(c.getUrl()).build());
		}
		return responseContentList;
	}
}
