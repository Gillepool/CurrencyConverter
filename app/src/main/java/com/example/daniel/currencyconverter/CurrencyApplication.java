package com.example.daniel.currencyconverter;

import android.app.Application;

import com.example.daniel.currencyconverter.Currency.CurrencyModule;
import com.example.daniel.currencyconverter.Network.NetworkModule;

/**
 * Created by Daniel on 2017-11-12.
 */

public class CurrencyApplication extends Application{

    private CurrencyApplicationComponent cac;

    @Override
    public void onCreate(){
        super.onCreate();
        cac = DaggerCurrencyApplicationComponent.builder()
                .currencyModule(new CurrencyModule())
                .networkModule(new NetworkModule())
                .currencyApplicationModule(new CurrencyApplicationModule(this))
                .build();
    }

    public CurrencyApplicationComponent getCurrencyApplicationComponent(){
        return cac;
    }
}
