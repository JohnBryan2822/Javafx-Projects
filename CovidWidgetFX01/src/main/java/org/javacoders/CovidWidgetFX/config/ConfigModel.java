package org.javacoders.CovidWidgetFX.config;

public class ConfigModel {
	private int refreshIntervalInSeconds;
	private String countryName;
	private String contryCode;
	
	public ConfigModel(int refreshIntervalInSeconds, String countryName, String contryCode) {
		this.refreshIntervalInSeconds = refreshIntervalInSeconds;
		this.countryName = countryName;
		this.contryCode = contryCode;
	}

	public ConfigModel() {
		refreshIntervalInSeconds = 300;
		countryName = "India";
		contryCode = "IN";
	}

	public int getRefreshIntervalInSeconds() {
		return refreshIntervalInSeconds;
	}

	public void setRefreshIntervalInSeconds(int refreshIntervalInSeconds) {
		this.refreshIntervalInSeconds = refreshIntervalInSeconds;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	@Override
	public String toString() {
		return "ConfigModel [refreshIntervalInSeconds=" + refreshIntervalInSeconds + ", countryName=" + countryName
				+ ", contryCode=" + contryCode + "]";
	}
}
