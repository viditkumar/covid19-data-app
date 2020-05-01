package com.covid19.data.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.data.dao.Covid19DataClientDao;
import com.covid19.data.model.Covid19CountryData;
import com.covid19.data.model.Covid19Data;
import com.covid19.data.service.Covid19DataJsonParsingService;
import com.covid19.data.util.Covid19DataConstants;
import com.covid19.data.util.GeneratePdfReport;

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
	public List<Covid19CountryData> getCountryData(@PathVariable String country) {
		List<Covid19CountryData> covid19CountryData = covid19DataClientDao.getCountryData();
		return covid19CountryData;
	}

	@GetMapping("/getData/{country}/{state}")
	@ResponseBody
	public void getStateData(@PathVariable String state) {

	}

	@GetMapping(value = "/getPdfFile", produces = MediaType.APPLICATION_PDF_VALUE)
	@ResponseBody
	public ResponseEntity<InputStreamResource> getPdfFile() {
		List<Covid19CountryData> covid19CountryData = covid19DataClientDao.getCountryData();

		ByteArrayInputStream bis = GeneratePdfReport.covid19Report(covid19CountryData);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=Covid19Report.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
