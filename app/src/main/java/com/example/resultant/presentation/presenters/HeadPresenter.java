package com.example.resultant.presentation.presenters;

import com.example.resultant.App;
import com.example.resultant.data.repository.AppRepository;
import com.example.resultant.presentation.fragments.ViewHead;
import com.example.resultant.rx.RxNetwork;
import io.reactivex.disposables.Disposable;

/**
 * @author Libgo on 11.02.2018.
 */

public class HeadPresenter implements BasePresenter {

    private AppRepository appRepository = App.getAppComponent().getAppRepository();
    private ViewHead viewHead;
    private Disposable disposable;

    @Override
    public void init(ViewHead viewHead) {
          this.viewHead = viewHead;
    }

    @Override
    public void createView() {
        viewHead.isLoading(true);
        if(appRepository.getFillList()){
           viewHead.startShow(appRepository.getCurrencyList());
            viewHead.isLoading(false);
            if(disposable.isDisposed()){
                dataSubscribe();
            }
        }else{
             dataSubscribe();
        } 

    }

    @Override
    public void onError() {
        viewHead.errorShow();
    }

    @Override
    public void destroyView() {
        disposable.dispose();

    }

    private void dataSubscribe(){
        disposable = RxNetwork.getListCurrency()
                .doOnNext(list -> appRepository.setCurrencyList(list))
                .doOnNext(list -> {
                    viewHead.showToast(appRepository.getFirstRun(), false);
                    if(appRepository.getFirstRun())
                    appRepository.setFirstRun(false);
                })
                .subscribe(list -> {viewHead.startShow(list); viewHead.isLoading(false);},
                        throwable -> onError());
    }

    public void refresh(){
        disposable.dispose();
        dataSubscribe();
        if(appRepository.getFillList()) {
            viewHead.showToast(false, true);
        }
    }
}
