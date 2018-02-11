package com.example.resultant;

import android.app.Application;

import com.example.resultant.di.components.AppComponent;
import com.example.resultant.di.components.DaggerAppComponent;
import com.example.resultant.di.modules.ContextModule;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author Libgo on 10.02.2018.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
