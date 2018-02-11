package com.example.resultant.tools.mappers;

import com.example.resultant.data.Currency;
import com.example.resultant.data.answer.FullResponse;
import com.example.resultant.data.answer.Price;
import com.example.resultant.data.answer.Stock;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Libgo on 11.02.2018.
 */

public class Mappers {

    public static List<Currency> mapListCurrency(FullResponse fullResponse){

        List<Currency> currencyList = new ArrayList<>();

        for (Stock stock : fullResponse.getStock()){
            Currency currency = new Currency();
            Price price = stock.getPrice();
            currency.setName(stock.getName());
            currency.setVolume(stock.getVolume());
            currency.setAmount(price.getAmount());
            currencyList.add(currency);
        }
        return currencyList;

    }

}
