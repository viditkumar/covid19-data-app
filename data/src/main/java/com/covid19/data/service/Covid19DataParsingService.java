package com.covid19.data.service;

import org.springframework.stereotype.Service;

import com.covid19.data.model.Covid19Data;

@Service
public interface Covid19DataParsingService {

	Covid19Data parse(String url);

}
