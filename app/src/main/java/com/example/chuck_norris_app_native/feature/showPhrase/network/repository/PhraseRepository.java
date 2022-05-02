package com.example.chuck_norris_app_native.feature.showPhrase.network.repository;

import com.example.chuck_norris_app_native.BuildConfig;
import com.example.chuck_norris_app_native.feature.showPhrase.network.dataSource.PhraseDataSource;
import com.example.chuck_norris_app_native.feature.showPhrase.network.model.Phrase;
import com.google.gson.internal.GsonBuildConfig;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhraseRepository {
    private PhraseDataSource service;
    public static Map<String, String> headers;

    public PhraseRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PhraseDataSource.class);
    }

    public Call<Phrase> getPhrase() {
        return service.getPhrase(getHeaders());
    }

    public static Map<String, String> getHeaders() {
        if(headers == null) {
            headers = new HashMap<>();
            headers.put("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com");
            headers.put("x-rapidapi-key", "27aa06345fmsh8f4bfc85f8d8f7dp1ba148jsn9b86ffbf73f8");
        }

        return headers;
    }
}
