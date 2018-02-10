package com.example.resultant;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author Libgo on 10.02.2018.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
