package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Daniel on 2017-11-11.
 */

public interface CurrencyRepository {
    Observable<Envelope> getResponse();
}
