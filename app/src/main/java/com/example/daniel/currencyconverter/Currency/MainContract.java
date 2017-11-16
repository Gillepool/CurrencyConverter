package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Observable;

public class MainContract {

    public interface View {
        void showError();
        void showRates(Envelope rates);
        void showResult(String value);
    }

    public interface Presenter {
        void setView(View view);
        void onBaseSelected();
        void onValueChanged(double rateFrom,double rateTo,  String value);
        void switchCurrencies(int from, int to);

    }

    public interface Model{
        Observable<Envelope> getCurrency();
    }

}
