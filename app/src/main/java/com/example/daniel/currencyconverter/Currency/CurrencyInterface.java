package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlModels.Gesmes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyInterface {

    @GET("eurofxref-daily.xml")
    Call<Gesmes> latest();

}
