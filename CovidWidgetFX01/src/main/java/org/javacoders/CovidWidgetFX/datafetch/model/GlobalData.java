package org.javacoders.CovidWidgetFX.datafetch.model;

public class GlobalData {
	
	private long recovered;
	private long cases;
	private long deaths;
	public GlobalData(long recovered, long cases, long deaths) {
		super();
		this.recovered = recovered;
		this.cases = cases;
		this.deaths = deaths;
	}
	public GlobalData() {
		super();
	}
	public long getRecovered() {
		return recovered;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public long getCases() {
		return cases;
	}
	public void setCases(long cases) {
		this.cases = cases;
	}
	public long getDeaths() {
		return deaths;
	}
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	@Override
	public String toString() {
		return "GlobalData [recovered=" + recovered + ", cases=" + cases + ", deaths=" + deaths + "]";
	}
}
