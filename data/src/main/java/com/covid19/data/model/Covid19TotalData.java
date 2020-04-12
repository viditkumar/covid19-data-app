package com.covid19.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Covid19TotalData {

	private String country;
	private String dailyconfirmed;
	private String dailydeceased;
	private String dailyrecovered;
	private String date;
	private String totalconfirmed;
	private String totaldeceased;
	private String totalrecovered;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDailyconfirmed() {
		return dailyconfirmed;
	}

	public void setDailyconfirmed(String dailyconfirmed) {
		this.dailyconfirmed = dailyconfirmed;
	}

	public String getDailydeceased() {
		return dailydeceased;
	}

	public void setDailydeceased(String dailydeceased) {
		this.dailydeceased = dailydeceased;
	}

	public String getDailyrecovered() {
		return dailyrecovered;
	}

	public void setDailyrecovered(String dailyrecovered) {
		this.dailyrecovered = dailyrecovered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotalconfirmed() {
		return totalconfirmed;
	}

	public void setTotalconfirmed(String totalconfirmed) {
		this.totalconfirmed = totalconfirmed;
	}

	public String getTotaldeceased() {
		return totaldeceased;
	}

	public void setTotaldeceased(String totaldeceased) {
		this.totaldeceased = totaldeceased;
	}

	public String getTotalrecovered() {
		return totalrecovered;
	}

	public void setTotalrecovered(String totalrecovered) {
		this.totalrecovered = totalrecovered;
	}
}
