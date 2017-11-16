package com.example.daniel.currencyconverter.Currency;

import android.support.annotation.Nullable;

import com.example.daniel.currencyconverter.Scheduler.Schedule;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainPresenter implements MainContract.Presenter {

    @Nullable
    private MainContract.View mView;
    private Schedule schedule;


    private CurrencyRepository.Network networkRespsotory;
    private MainContract.Model model;

    @Inject
    public MainPresenter(CurrencyRepository.Network networkRespsotory, Schedule schedule, MainContract.Model model) {
        this.networkRespsotory = networkRespsotory;
        this.schedule = schedule;
        this.model = model;
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onBaseSelected() {
        if(mView!=null){
            Observable<Envelope> currenciesObs = model.getCurrency();
            currenciesObs
                    .subscribeOn(schedule.getScheduler())
                    .observeOn(schedule.getMainThread())
                    .subscribe(currencies -> mView.showRates(currencies),
                            error-> mView.showError());
        }
    }

    @Override
    public void onValueChanged(double rateFrom, double rateTo, String value) {
        try {
            double result = Double.parseDouble(value)/rateFrom;
            double convertResult = result * rateTo;
            mView.showResult(String.format(Locale.getDefault(), "%.2f", convertResult));
        } catch (NumberFormatException e) {
            mView.showResult(null);
        }
    }

    @Override
    public void switchCurrencies(int from, int to) {

    }

}
