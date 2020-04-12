package com.covid19.data.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Covid19Data {

	private List<Covid19TotalData> cases_time_series;
	private List<Covid19CountryData> statewise;

	public List<Covid19TotalData> getCases_time_series() {
		return cases_time_series;
	}

	public void setCases_time_series(List<Covid19TotalData> cases_time_series) {
		this.cases_time_series = cases_time_series;
	}

	public List<Covid19CountryData> getStatewise() {
		return statewise;
	}

	public void setStatewise(List<Covid19CountryData> statewise) {
		this.statewise = statewise;
	}

}
