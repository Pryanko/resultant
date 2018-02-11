package com.example.resultant.network;

import com.example.resultant.data.answer.FullResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import static com.example.resultant.constants.Constants.API_URL;

/**
 * @author Libgo on 11.02.2018.
 */

public interface ApiService  {

    @GET("stocks.json")
    Observable<FullResponse> getFullresponse();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            //Для всех запросов используется шедулер созданный выше.
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
