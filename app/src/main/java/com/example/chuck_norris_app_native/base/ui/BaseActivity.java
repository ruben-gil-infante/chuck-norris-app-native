package com.example.chuck_norris_app_native.base.ui;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static String TAG = "BaseActivity";
    public abstract void setListeners();
    public abstract void showProgressBar();
    public abstract void hideProgressBar();
}
