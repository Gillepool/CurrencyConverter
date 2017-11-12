package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.Network.NetworkModule;
import com.example.daniel.currencyconverter.Network.NetworkRepository;
import com.example.daniel.currencyconverter.Scheduler.Schedule;
import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 2017-11-12.
 */

@Module(includes = {NetworkModule.class})
public class CurrencyModule {

    @Provides
    public MainContract.Presenter provideMainContractPresenter(CurrencyRepository currencyRepository, Schedule schedule){
        return new MainPresenter(currencyRepository, schedule);
    }

    @Provides
    public CurrencyRepository providesCurrencyRepository(CurrencyApi currencyApi){
        return new NetworkRepository(currencyApi);
    }

}
