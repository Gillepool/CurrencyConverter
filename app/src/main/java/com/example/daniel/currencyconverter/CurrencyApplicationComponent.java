package com.example.daniel.currencyconverter;

import com.example.daniel.currencyconverter.Currency.CurrencyModule;
import com.example.daniel.currencyconverter.Network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniel on 2017-11-12.
 */

@Singleton
@Component(modules = {NetworkModule.class, CurrencyApplicationModule.class, CurrencyModule.class})
public interface CurrencyApplicationComponent {

    void inject(MainActivity mainActivity);
}
