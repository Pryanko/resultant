package com.example.resultant.di.modules;

import com.example.resultant.presentation.presenters.HeadPresenter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * @author Libgo on 11.02.2018.
 */
@Module
@Singleton
public class PresenterModule {

    @Provides
    @Singleton
    HeadPresenter headPresenter(){
        return new HeadPresenter();
    }

}
