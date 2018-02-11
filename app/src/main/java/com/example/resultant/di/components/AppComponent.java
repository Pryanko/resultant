package com.example.resultant.di.components;

import android.content.Context;

import com.example.resultant.data.repository.AppRepository;
import com.example.resultant.di.modules.ContextModule;
import com.example.resultant.di.modules.PresenterModule;
import com.example.resultant.di.modules.RepositoryModule;
import com.example.resultant.presentation.presenters.HeadPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Libgo on 11.02.2018.
 */
@Singleton
@Component (modules = {PresenterModule.class, RepositoryModule.class, ContextModule.class})
public interface AppComponent {

    HeadPresenter getHeadPresenter();

    AppRepository getAppRepository();

    Context getContext();

}
