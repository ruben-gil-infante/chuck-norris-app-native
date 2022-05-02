package com.example.chuck_norris_app_native.feature.showPhrase.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuck_norris_app_native.R;
import com.example.chuck_norris_app_native.base.ui.BaseActivity;
import com.example.chuck_norris_app_native.base.ui.BaseActivityWithViewModel;
import com.example.chuck_norris_app_native.feature.showPhrase.viewModel.ShowPhraseViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowPhraseActivity extends BaseActivityWithViewModel<ShowPhraseViewModel> {

    @BindView(R.id.show_phrase_activity_layout_progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.show_phrase_activity_layout_phrase)
    TextView phraseTv;
    @BindView(R.id.show_phrase_activity_layout_more_btn)
    TextView moreBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_phrase_activity_layout);
        ButterKnife.bind(this);
        injectViewModel();
        setListeners();
        obtainFirstPhrase();
    }

    private void injectViewModel() {
        viewModel = new ViewModelProvider(this).get(ShowPhraseViewModel.class);
    }


    @Override
    public void setListeners() {
        moreBtn.setOnClickListener(this);
        viewModel.getShowProgressBar().observe(this, newValue -> {
            if (newValue)
                showProgressBar();
            else
                hideProgressBar();
        });
        viewModel.getPhrase().observe(this, newValue -> {
            phraseTv.setText(newValue.toString());
        });
    }

    private void obtainFirstPhrase() {
        viewModel.callToGetANewPhrase();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        phraseTv.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        phraseTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == moreBtn.getId()) {
            animateMoreBtn();
            viewModel.callToGetANewPhrase();
        }
    }

    private void animateMoreBtn() {
        moreBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.big_scale_btn));
    }
}
