package com.example.resultant.rx;

import com.example.resultant.data.Currency;
import com.example.resultant.network.ApiService;
import com.example.resultant.tools.mappers.Mappers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * @author Libgo on 11.02.2018.
 */

public class RxNetwork {

    private static ApiService apiService = ApiService.retrofit.create(ApiService.class);

    public static Observable<List<Currency>> getListCurrency(){
        return  apiService.getFullresponse()
                .map(Mappers::mapListCurrency)
                .repeatWhen(objectObservable -> objectObservable.delay(15, TimeUnit.SECONDS))
                .observeOn(AndroidSchedulers.mainThread());

    }
}
