package com.example.daniel.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import com.example.daniel.currencyconverter.Currency.CurrencyAdapter;
import com.example.daniel.currencyconverter.Currency.CurrencyRepository;
import com.example.daniel.currencyconverter.Currency.MainContract;
import com.example.daniel.currencyconverter.Currency.MainPresenter;
import com.example.daniel.currencyconverter.Network.NetworkRepository;
import com.example.daniel.currencyconverter.Scheduler.Schedule;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainContract.View {

    @Inject
    MainContract.Presenter mPresenter;
    private CurrencyAdapter mCurrencyAdapter;
    @Inject
    CurrencyRepository currencyRepository;

    private String[] mCurrencies;

    @BindView(R.id.base_selector)  Spinner mBaseSpinner;
    @BindView(R.id.list) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((CurrencyApplication) getApplication()).getCurrencyApplicationComponent().inject(this);


        mPresenter.setView(this);



        mPresenter.onBaseSelected();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.setView(null);
    }

    @Override
    public void showError() {
        mRecyclerView.setAdapter(null);

    }

    @Override
    public void showRates(Envelope rates) {
        mRecyclerView.setAdapter(
                new CurrencyAdapter(rates));
    }


}
