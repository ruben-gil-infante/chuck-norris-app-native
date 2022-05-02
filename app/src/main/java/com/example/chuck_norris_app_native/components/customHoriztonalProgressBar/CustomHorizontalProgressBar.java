package com.example.chuck_norris_app_native.components.customHoriztonalProgressBar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.chuck_norris_app_native.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomHorizontalProgressBar extends ConstraintLayout {

    private static final String TAG = "CustomHoriztonalProgressBarComponent";

    @BindView(R.id.custom_horizontal_progress_bar_layout_subbar)
    View subbar;
    private Animation subbarAnimation;

    public CustomHorizontalProgressBar(@NonNull Context context) {
        super(context);
        initView();

    }

    public CustomHorizontalProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomHorizontalProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public CustomHorizontalProgressBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();

    }

    private void initView() {
        View root = inflate(getContext(), R.layout.custom_horiztonal_prgress_bar, this);
        ButterKnife.bind(this);
        loadAnimation();
        animateBar();
    }

    private void loadAnimation() {
  subbarAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.custom_horizontal_progress_bar_anim);
    subbarAnimation.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            animateBar();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    });
    }

    private void animateBar() {
       subbar.startAnimation(subbarAnimation);
    }



}
