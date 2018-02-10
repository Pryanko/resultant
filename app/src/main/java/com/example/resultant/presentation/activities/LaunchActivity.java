package com.example.resultant.presentation.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.resultant.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Libgo on 10.02.2018.
 */

public class LaunchActivity extends AppCompatActivity {

    @BindView(R.id.logo_image)
    SimpleDraweeView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        startShow();

    }

    private void startShow(){
        logoImage.setImageResource(R.drawable.ic_logo);
        logoImage.animate().alpha(1.0f).setDuration(1400).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                endShow();
            }
        });

    }

    private void endShow() {
        startActivity(new Intent(this, HeadActivity.class));
        finish();
    }
}
