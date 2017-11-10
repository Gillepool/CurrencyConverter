package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.XmlModels.Gesmes;

public class MainContract {

    public interface View {
        void showError();
        void showRates(Gesmes rates);
    }

    public interface Presenter {
        void setView(View view);
        void onBaseSelected();
    }

}
