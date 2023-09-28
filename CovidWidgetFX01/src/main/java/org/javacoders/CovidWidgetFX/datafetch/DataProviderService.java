package org.javacoders.CovidWidgetFX.datafetch;

import java.util.concurrent.CompletableFuture;

import org.javacoders.CovidWidgetFX.datafetch.model.CountryData;
import org.javacoders.CovidWidgetFX.datafetch.model.CovidDataModel;
import org.javacoders.CovidWidgetFX.datafetch.model.GlobalData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProviderService {
	
	public CovidDataModel getData(String countryName) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		CovidApi covidApi = retrofit.create(CovidApi.class);
		CompletableFuture<GlobalData> callback1 = new CompletableFuture<GlobalData>();
		covidApi.getGlobalData()
				.enqueue(new Callback<GlobalData>() {
					
					@Override
					public void onResponse(Call<GlobalData> call, Response<GlobalData> response) {
						callback1.complete(response.body());
						
					}
					
					@Override
					public void onFailure(Call<GlobalData> call, Throwable t) {
						callback1.completeExceptionally(t);
					}
				});
		
		CompletableFuture<CountryData> callback2 = new CompletableFuture<CountryData>();
		
		covidApi.getCountryData(countryName)
			.enqueue(new Callback<CountryData>() {
				
				@Override
				public void onResponse(Call<CountryData> call, Response<CountryData> response) {
					callback2.complete(response.body());
				}
				
				@Override
				public void onFailure(Call<CountryData> call, Throwable t) {
					callback2.completeExceptionally(t);
				}
			});
		
		GlobalData globalData = callback1.join();
		CountryData countryData = callback2.join();
		
		return new CovidDataModel(globalData, countryData);
	}
}
