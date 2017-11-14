package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Single;

public class MainContract {

    public interface View {
        void showError();
        void showRates(Envelope rates);
    }

    public interface Presenter {
        void setView(View view);
        void onBaseSelected();
    }

    public interface Model{
        Single<Envelope> getCurrency();
    }

}
