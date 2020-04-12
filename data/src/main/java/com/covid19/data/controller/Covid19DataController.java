package com.covid19.data.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.data.dao.Covid19DataClientDao;
import com.covid19.data.model.Covid19Data;
import com.covid19.data.service.Covid19DataJsonParsingService;
import com.covid19.data.util.Covid19DataConstants;

@RestController
public class Covid19DataController {

	@Autowired
	private Covid19DataJsonParsingService covid19DataJsonParsingService;

	@Autowired
	private Covid19DataClientDao covid19DataClientDao;

	Covid19Data covid19Data = new Covid19Data();

	@PostConstruct
	public void initCovid19Data() {
		covid19Data = covid19DataJsonParsingService.parse(Covid19DataConstants.INDIA_URL);
		covid19DataClientDao.saveTotalData(covid19Data.getCases_time_series());
		covid19DataClientDao.saveCountryData(covid19Data.getStatewise());
	}

	@GetMapping("/getData/{country}")
	@ResponseBody
	public void getCountryData(@PathVariable String country) {

	}

	@GetMapping("/getData/{country}/{state}")
	@ResponseBody
	public void getStateData(@PathVariable String state) {

	}
}
