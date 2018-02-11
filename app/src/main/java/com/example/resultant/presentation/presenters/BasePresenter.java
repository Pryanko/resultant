package com.example.resultant.presentation.presenters;

import com.example.resultant.presentation.fragments.ViewHead;

/**
 * @author Libgo on 11.02.2018.
 */

public interface BasePresenter {

    void init(ViewHead viewHead);

    void createView();

    void onError();

    void destroyView();

}
