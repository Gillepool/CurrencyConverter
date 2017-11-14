package com.example.daniel.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Spinner;

import com.example.daniel.currencyconverter.Currency.CurrencyAdapter;
import com.example.daniel.currencyconverter.Currency.MainContract;
import com.example.daniel.currencyconverter.Currency.MainPresenter;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainContract.View {

    @Inject
    MainPresenter mPresenter;

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
        Log.d("response", rates.toString());
        mRecyclerView.setAdapter(new CurrencyAdapter(rates));
    }


}
