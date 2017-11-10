package com.example.daniel.currencyconverter.XmlModels;

import org.simpleframework.xml.Attribute;

/**
 * Created by Daniel on 2017-11-10.
 */

public class Cubes {


    @Attribute(name="currency")
    private String currency;
    @Attribute(name="rate")
    private String rate;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Cubes{" +
                "currency='" + currency + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
