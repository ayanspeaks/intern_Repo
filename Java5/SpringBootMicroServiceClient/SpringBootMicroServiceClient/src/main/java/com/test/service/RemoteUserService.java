package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteUserService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public String serviceUrl;
	
	public RemoteUserService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http")?
				serviceUrl: "http://"+serviceUrl;
	}
	
	public String getUserResponse() {
		String response = restTemplate.getForObject(serviceUrl+"/testuser", String.class);
		
		return response;
	}

}
