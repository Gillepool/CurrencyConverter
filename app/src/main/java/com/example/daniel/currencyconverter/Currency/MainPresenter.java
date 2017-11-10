package com.example.daniel.currencyconverter.Currency;

import android.util.Log;

import com.example.daniel.currencyconverter.XmlModels.Gesmes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private CurrencyInterface mService;

    public MainPresenter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.ecb.europa.eu/stats/eurofxref/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        mService = retrofit.create(CurrencyInterface.class);
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onBaseSelected() {

        mService.latest().enqueue(new Callback<Gesmes>() {
            @Override
            public void onResponse(Call<Gesmes> call, Response<Gesmes> response) {
                if (mView != null) {
                    mView.showRates(response.body());
                }
            }

            @Override
            public void onFailure(Call<Gesmes> call, Throwable t) {
                String message = t.getMessage();
                Log.d("failure:" , t.getLocalizedMessage());
                Log.d("failure", message);
                if (mView != null) {
                    mView.showError();
                }
            }
        });

    }

}
