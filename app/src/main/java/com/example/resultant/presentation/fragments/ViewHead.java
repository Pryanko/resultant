package com.example.resultant.presentation.fragments;


import com.example.resultant.data.Currency;
import java.util.List;

/**
 * @author Libgo on 11.02.2018.
 */

public interface ViewHead {


    void isLoading(Boolean isLoading);

    void startShow(List<Currency> list);

    void errorShow();

    void showToast(Boolean firstRun, Boolean refresh);


}
