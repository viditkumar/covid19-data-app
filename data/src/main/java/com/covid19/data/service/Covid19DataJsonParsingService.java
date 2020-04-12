package com.covid19.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid19.data.model.Covid19Data;

@Service
public class Covid19DataJsonParsingService implements Covid19DataParsingService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Covid19Data parse(String url) {
		return restTemplate.getForObject(url, Covid19Data.class);
	}

}
