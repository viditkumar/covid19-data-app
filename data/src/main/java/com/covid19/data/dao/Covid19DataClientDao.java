package com.covid19.data.dao;

import java.util.List;

import com.covid19.data.model.Covid19CountryData;
import com.covid19.data.model.Covid19TotalData;

public interface Covid19DataClientDao {

	public void saveTotalData(List<Covid19TotalData> covid19TotalData);

	public void saveCountryData(List<Covid19CountryData> covid19CountryData);
	
	public List<Covid19CountryData> getCountryData();

}
