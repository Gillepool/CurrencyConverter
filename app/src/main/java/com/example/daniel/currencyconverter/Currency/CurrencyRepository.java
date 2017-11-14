package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Single;

/**
 * Created by Daniel on 2017-11-11.
 */

public interface CurrencyRepository {
    interface Network{
        Single<Envelope> getResponse();
    }

    interface File{
        Envelope readFromFile();
        void saveToFile(Envelope envelope);
    }
}
