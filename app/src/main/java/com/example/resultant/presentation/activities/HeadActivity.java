package com.example.resultant.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.resultant.R;
import com.example.resultant.presentation.fragments.HeadFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Libgo on 10.02.2018.
 */

public class HeadActivity extends AppCompatActivity {

    @BindView(R.id.app_toolbar)
    Toolbar appToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        ButterKnife.bind(this);
        initToolBar();
        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_fragments, new HeadFragment())
                    .commit();
        }
    }

    private void initToolBar(){
        appToolbar.setTitle(R.string.app_title_name);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(appToolbar);

    }
}
