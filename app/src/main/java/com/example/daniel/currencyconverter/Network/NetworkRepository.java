package com.example.daniel.currencyconverter.Network;

import com.example.daniel.currencyconverter.Currency.CurrencyApi;
import com.example.daniel.currencyconverter.Currency.CurrencyRepository;
import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Daniel on 2017-11-11.
 */

public class NetworkRepository implements CurrencyRepository {

    CurrencyApi currencyApi;

    public NetworkRepository(CurrencyApi currencyApi){
        this.currencyApi = currencyApi;
    }

    @Override
    public Observable<Envelope> getResponse() {
        Observable<Envelope> responseObservable = currencyApi.getData();
        return responseObservable;
    }
}
