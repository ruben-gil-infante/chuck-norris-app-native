package com.example.chuck_norris_app_native.feature.splash.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.chuck_norris_app_native.R;
import com.example.chuck_norris_app_native.feature.showPhrase.ui.activity.ShowPhraseActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        mockLoading();
    }

    private void mockLoading() {
        Thread timer = new Thread() {
            public void run(){
                try {
                    sleep(2000);
                    goToPhraseActivity();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();

    }

    private void goToPhraseActivity() {
        Intent intent = new Intent(this, ShowPhraseActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}