package com.example.daniel.currencyconverter.XmlResponseModels;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Daniel on 2017-11-10.
 */

@Root(name = "Cube/Cube")
public class CurrencyCube implements Serializable {


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
        return "CurrencyCube{" +
                "currency='" + currency + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
