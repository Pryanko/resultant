package com.example.resultant.di.modules;

import com.example.resultant.data.repository.AppRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Libgo on 11.02.2018.
 */
@Module
@Singleton
public class RepositoryModule {

    @Provides
    @Singleton
    AppRepository appRepository(){
        return new AppRepository();
    }

}
