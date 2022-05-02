package com.example.chuck_norris_app_native.base.ui;


public abstract class BaseActivityWithViewModel<E> extends BaseActivity {
    public E viewModel;

    public abstract void injectViewModel();
}
