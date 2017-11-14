package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CurrencyApi {

    @GET("eurofxref-daily.xml")
    Single<Envelope> getData();

}
