package com.example.resultant.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.resultant.R;
import com.example.resultant.data.Currency;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.resultant.constants.Constants.DOUBLE_FORMAT;

/**
 * @author Libgo on 11.02.2018.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>{

    private List<Currency> currencyList = new ArrayList<>();

    public void updateList(List<Currency> currencyList){
        if(currencyList.isEmpty()){
            this.currencyList = currencyList;
        }else {
            this.currencyList.clear();
            this.currencyList = currencyList;
        }
        notifyDataSetChanged();
    }

    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurrencyAdapter.ViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.textName.setText(currency.getName());
        holder.textVolume.setText(String.valueOf(currency.getVolume()));
        holder.textAmount.setText(new DecimalFormat(DOUBLE_FORMAT).format(currency.getAmount()));

    }

    @Override
    public int getItemCount() {
        if(currencyList.size() != 0){
            return currencyList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_volume)
        TextView textVolume;
        @BindView(R.id.text_amount)
        TextView textAmount;


         ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
