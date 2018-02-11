package com.example.resultant.data.repository;

import com.example.resultant.data.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Libgo on 11.02.2018.
 */

public class AppRepository {

    private List<Currency> currencyList = new ArrayList<>();


    public Boolean getFillList(){
        return fillList();
    }

    private Boolean fillList(){
        return currencyList.size() > 0;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
