package application;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DataProviderService {

    public CovidDataModel getData(String countryName) {
    	
    	System.out.println("Refreshing data...2");
        
    	Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
    	System.out.println("Refreshing data...3");
        
    	CovidApi covidApi = retrofit.create(CovidApi.class);
        
    	System.out.println("Refreshing data...4");
        
    	CompletableFuture<GlobalData> callback1 = new CompletableFuture<>();
        
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

        CompletableFuture<CountryData> callback2 = new CompletableFuture<>();
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
        CountryData country = callback2.join();

        return new CovidDataModel(globalData, country);
    }
    
    public CovidDataModel getData2(String countryName) {
    	try {
    		System.out.println("Hello .. 1");
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/covid-19/country-data/" + countryName).asJson();
            System.out.println("Hello .. 2");
            CountryData countryData = new Gson().fromJson(apiResponse.getBody().toString(), CountryData.class);
            System.out.println("Hello .. 3");
            HttpResponse<JsonNode> apiResponse2 = Unirest.get("http://localhost:8080/covid-19/global-data").asJson();
            System.out.println("Hello .. 4");
            GlobalData globalData = new Gson().fromJson(apiResponse2.getBody().toString(), GlobalData.class);
            System.out.println("Hello .. 5");
            return new CovidDataModel(globalData, countryData);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}














