package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.List;

public class MainContract {

    public interface View {
        void showError();
        void showRates(Envelope rates);
    }

    public interface Presenter {
        void setView(View view);
        void onBaseSelected();
    }

}
