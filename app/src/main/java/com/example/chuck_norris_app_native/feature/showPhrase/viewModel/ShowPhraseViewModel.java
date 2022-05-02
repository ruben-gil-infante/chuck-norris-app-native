package com.example.chuck_norris_app_native.feature.showPhrase.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chuck_norris_app_native.feature.showPhrase.network.model.Phrase;
import com.example.chuck_norris_app_native.feature.showPhrase.useCase.ShowPhraseUseCase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPhraseViewModel extends ViewModel {
    private static final String TAG = "ShowPhraseViewModel";

    private ShowPhraseUseCase showPhraseUseCase;
    private MutableLiveData<Boolean> showProgressBar;
    private MutableLiveData<String> phrase;

    public ShowPhraseViewModel() {
        showProgressBar = new MutableLiveData<>();
        showPhraseUseCase = new ShowPhraseUseCase();
        phrase = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getShowProgressBar() {
        return showProgressBar;
    }

    public MutableLiveData<String> getPhrase() { return phrase; }

    public void callToGetANewPhrase() {
        showProgressBar.postValue(true);
        showPhraseUseCase.getPhrase().enqueue(new Callback<Phrase>() {
            @Override
            public void onResponse(Call<Phrase> call, Response<Phrase> response) {
                showProgressBar.postValue(false);
                phrase.postValue(response.body().getValue());
            }

            @Override
            public void onFailure(Call<Phrase> call, Throwable t) {
                showProgressBar.postValue(false);
                phrase.postValue("Something went wrong...");
            }
        });

    }

}
