package com.example.chuck_norris_app_native.feature.showPhrase.useCase;

import com.example.chuck_norris_app_native.feature.showPhrase.network.model.Phrase;
import com.example.chuck_norris_app_native.feature.showPhrase.network.repository.PhraseRepository;

import retrofit2.Call;

public class ShowPhraseUseCase {
    private PhraseRepository repository;

    public ShowPhraseUseCase() {
        if(repository == null)
            repository = new PhraseRepository();
    }

    public Call<Phrase> getPhrase(){
        return repository.getPhrase();
    }
}
