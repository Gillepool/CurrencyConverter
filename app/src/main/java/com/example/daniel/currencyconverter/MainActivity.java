package com.example.daniel.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.daniel.currencyconverter.Currency.CurrencyAdapter;
import com.example.daniel.currencyconverter.Currency.MainContract;
import com.example.daniel.currencyconverter.Currency.MainPresenter;
import com.example.daniel.currencyconverter.XmlModels.Gesmes;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private String[] mCurrencies;

    @BindView(R.id.base_selector)  Spinner mBaseSpinner;
    @BindView(R.id.list) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenter();
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
    public void showRates(Gesmes rates) {
        mRecyclerView.setAdapter(
                new CurrencyAdapter((String) mBaseSpinner.getSelectedItem(), rates));
    }
}
