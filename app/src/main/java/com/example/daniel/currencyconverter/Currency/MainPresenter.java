package com.example.daniel.currencyconverter.Currency;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.daniel.currencyconverter.Scheduler.Schedule;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

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
            Single<Envelope> currenciesObs = model.getCurrency();
            Log.d("response", currenciesObs.toString());
            currenciesObs
                    .subscribeOn(schedule.getScheduler())
                    .observeOn(schedule.getMainThread())
                    .subscribe(currencies -> mView.showRates(currencies),
                            error-> mView.showError());
        }
    }

}
