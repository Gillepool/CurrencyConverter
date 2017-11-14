package com.example.daniel.currencyconverter.Network;

/**
 * Created by Daniel on 2017-11-11.
 */

import com.example.daniel.currencyconverter.Currency.CurrencyApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("http://www.ecb.europa.eu/stats/eurofxref/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    CurrencyApi provideCurrencyApi(Retrofit retrofit){
        return retrofit.create(CurrencyApi.class);
    }
}
