CREATE TABLE covid19_total_data (
    country VARCHAR2,
    dailyConfirmed VARCHAR2,
	dailyDeceased VARCHAR2,
	dailyRecovered VARCHAR2,
	date VARCHAR2,
	totalConfirmed VARCHAR2,
	totalDeceased VARCHAR2,
	totalRecovered VARCHAR2
);

CREATE TABLE covid19_country_data (
    country VARCHAR2,
    active VARCHAR2,
	confirmed VARCHAR2,
	deaths VARCHAR2,
	deltaConfirmed VARCHAR2,
	deltaDeaths VARCHAR2,
	deltaRecovered VARCHAR2,
	lastUpdatedtime VARCHAR2,
	recovered VARCHAR2,
	state VARCHAR2,
	stateCode VARCHAR2,
	stateNotes VARCHAR2
);
