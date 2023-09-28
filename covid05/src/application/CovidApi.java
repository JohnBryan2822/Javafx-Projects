package application;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidApi {
    @GET("http://localhost:8080/covid-19/global-data")
    Call<GlobalData> getGlobalData();

    @GET("http://localhost:8080/covid-19/country-data/{countryName}")
    Call<CountryData> getCountryData(@Path(value = "countryName") String countryName);
}
