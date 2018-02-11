package com.example.resultant.data.answer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Libgo on 11.02.2018.
 */

public class FullResponse {

    @SerializedName("stock")
    @Expose
    private List<Stock> stock = null;
    @SerializedName("as_of")
    @Expose
    private String asOf;

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public String getAsOf() {
        return asOf;
    }

    public void setAsOf(String asOf) {
        this.asOf = asOf;
    }


}
