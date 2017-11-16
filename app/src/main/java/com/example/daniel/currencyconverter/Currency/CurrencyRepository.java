package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Observable;

/**
 * Created by Daniel on 2017-11-11.
 */

public interface CurrencyRepository {
    interface Network{
        Observable<Envelope> getResponse();
    }

    interface File{
        Envelope readFromFile();
        Envelope saveToFile(Envelope envelope);
    }
}
