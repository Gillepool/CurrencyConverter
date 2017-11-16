package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CurrencyApi {

    @GET("eurofxref-daily.xml")
    Observable<Envelope> getData();

}
