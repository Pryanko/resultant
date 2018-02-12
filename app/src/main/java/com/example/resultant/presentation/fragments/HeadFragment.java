package com.example.resultant.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.resultant.App;
import com.example.resultant.R;
import com.example.resultant.data.Currency;
import com.example.resultant.presentation.adapters.CurrencyAdapter;
import com.example.resultant.presentation.adapters.decoration.SpaceDecoration;
import com.example.resultant.presentation.presenters.HeadPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Libgo on 11.02.2018.
 */

public class HeadFragment extends Fragment implements ViewHead {

    @BindView(R.id.recycler_head)
    RecyclerView recyclerHead;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.head_layout)
    RelativeLayout relativeLayout;

    private CurrencyAdapter currencyAdapter;
    private LinearLayoutManager linearLayoutManager;
    private HeadPresenter headPresenter = App.getAppComponent().getHeadPresenter();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        headPresenter.init(this);
        currencyAdapter = new CurrencyAdapter();
        linearLayoutManager = new LinearLayoutManager(App.getAppComponent().getContext());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view =  inflater.inflate(R.layout.fragment_head, container, false);
        ButterKnife.bind(this, view);
        headPresenter.createView();
        recyclerHead.setLayoutManager(linearLayoutManager);
        recyclerHead.setAdapter(currencyAdapter);
        recyclerHead.addItemDecoration(new SpaceDecoration(5));
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.app_menu, menu);
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                headPresenter.refresh();
                return true;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        headPresenter.destroyView();
    }

    //implements
    @Override
    public void isLoading(Boolean isLoading) {
        if(isLoading){
            progressBar.setVisibility(View.VISIBLE);
            recyclerHead.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            recyclerHead.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void startShow(List<Currency> list) {
        currencyAdapter.updateList(list);
        Log.d("Responce", list.toString());
    }

    @Override
    public void errorShow() {
        Snackbar.make(relativeLayout, R.string.not_network, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.repeat, v ->
                       headPresenter.refresh()
                ).show();

    }

    @Override
    public void showToast() {
        Toast.makeText(App.getAppComponent().getContext(), R.string.refresher, Toast.LENGTH_SHORT)
                .show();
    }
}
