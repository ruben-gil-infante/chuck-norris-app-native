package com.example.chuck_norris_app_native.feature.showPhrase.network.dataSource;

import com.example.chuck_norris_app_native.feature.showPhrase.network.model.Phrase;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface PhraseDataSource {

    @GET("jokes/random")
    Call<Phrase> getPhrase(@HeaderMap Map<String, String> headers);
}
