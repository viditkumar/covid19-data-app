package com.covid19.data.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.covid19.data.dao.Covid19DataClientDao;
import com.covid19.data.model.Covid19CountryData;
import com.covid19.data.model.Covid19TotalData;

@Repository("covid19dataclientDao")
@PropertySource("classpath:covid19dataclient.properties")
public class Covid19DataClientDaoImpl implements Covid19DataClientDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${covid19.insert.totaldata}")
	public String insertTotalData;

	@Value("${covid19.insert.countrydata}")
	public String insertCountryData;

	@Value("${covid19.get.countrydata}")
	public String getCountryData;

	@Override
	public void saveTotalData(List<Covid19TotalData> covid19TotalData) {
		// batch-insert
		int[] updateCounts = jdbcTemplate.batchUpdate(insertTotalData, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, "INDIA");
				ps.setString(2, covid19TotalData.get(i).getDailyconfirmed());
				ps.setString(3, covid19TotalData.get(i).getDailydeceased());
				ps.setString(4, covid19TotalData.get(i).getDailyrecovered());
				ps.setString(5, covid19TotalData.get(i).getDate());
				ps.setString(6, covid19TotalData.get(i).getTotalconfirmed());
				ps.setString(7, covid19TotalData.get(i).getTotaldeceased());
				ps.setString(8, covid19TotalData.get(i).getTotalrecovered());
			}

			@Override
			public int getBatchSize() {
				return covid19TotalData.size();
			}
		});
	}

	@Override
	public void saveCountryData(List<Covid19CountryData> covid19CountryData) {
		// batch-insert
		int[] updateCounts = jdbcTemplate.batchUpdate(insertCountryData, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, "INDIA");
				ps.setString(2, covid19CountryData.get(i).getActive());
				ps.setString(3, covid19CountryData.get(i).getConfirmed());
				ps.setString(4, covid19CountryData.get(i).getDeaths());
				ps.setString(5, covid19CountryData.get(i).getDeltaconfirmed());
				ps.setString(6, covid19CountryData.get(i).getDeltadeaths());
				ps.setString(7, covid19CountryData.get(i).getDeltarecovered());
				ps.setString(8, covid19CountryData.get(i).getLastupdatedtime());
				ps.setString(9, covid19CountryData.get(i).getRecovered());
				ps.setString(10, covid19CountryData.get(i).getState());
				ps.setString(11, covid19CountryData.get(i).getStatecode());
				ps.setString(12, covid19CountryData.get(i).getStatenotes());
			}

			@Override
			public int getBatchSize() {
				return covid19CountryData.size();
			}
		});
	}

	@Override
	public List<Covid19CountryData> getCountryData() {
		return jdbcTemplate.query(getCountryData,
				(rs, rowNum) -> new Covid19CountryData(rs.getString("country"), rs.getString("active"),
						rs.getString("confirmed"), rs.getString("deaths"), rs.getString("deltaconfirmed"),
						rs.getString("deltadeaths"), rs.getString("deltarecovered"), rs.getString("lastupdatedtime"),
						rs.getString("recovered"), rs.getString("state"), rs.getString("statecode"),
						rs.getString("statenotes")));
	}
}
