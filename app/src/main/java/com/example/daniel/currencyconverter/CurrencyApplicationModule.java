package com.example.daniel.currencyconverter;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 2017-11-12.
 */

@Module
public class CurrencyApplicationModule {

    private Application app;

    public  CurrencyApplicationModule(Application app){
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return this.app;
    }
}
