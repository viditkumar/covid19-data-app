package com.covid19.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Covid19DataBeanConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
