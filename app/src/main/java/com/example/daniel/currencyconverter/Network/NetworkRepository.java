package com.example.daniel.currencyconverter.Network;

import com.example.daniel.currencyconverter.Currency.CurrencyApi;
import com.example.daniel.currencyconverter.Currency.CurrencyRepository;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Daniel on 2017-11-11.
 */

public class NetworkRepository implements CurrencyRepository.Network {

    CurrencyApi currencyApi;
    @Inject
    public NetworkRepository(CurrencyApi currencyApi){
        this.currencyApi = currencyApi;
    }

    @Override
    public Single<Envelope> getResponse() {
        Single<Envelope> responseObservable = currencyApi.getData();
        return responseObservable;
    }
}
