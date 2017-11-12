package com.example.daniel.currencyconverter.Currency;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.daniel.currencyconverter.Scheduler.Schedule;
import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.List;

import io.reactivex.Observable;

public class MainPresenter implements MainContract.Presenter {

    @Nullable
    private MainContract.View mView;
    private Schedule schedule;

    @NonNull
    private final CurrencyRepository mCurrencyRepository;

    public MainPresenter(@NonNull CurrencyRepository currencyRepository, Schedule schedule) {
        this.mCurrencyRepository = currencyRepository;
        this.schedule = schedule;
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.ecb.europa.eu/stats/eurofxref/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        mService = retrofit.create(CurrencyApi.class);
        */
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onBaseSelected() {

        if(mView!=null){
            Observable<Envelope> currenciesObs = mCurrencyRepository.getResponse();
            currenciesObs
                    .subscribeOn(schedule.getScheduler())
                    .observeOn(schedule.getMainThread())
                    .subscribe(currencies -> mView.showRates(currencies),
                            error-> mView.showError());
        }
        /*
        mService.getData().enqueue(new Callback<Envelope>() {
            @Override
            public void onResponse(Call<Envelope> call, Response<Envelope> response) {
                Log.d("success", response.body().toString());
                if (mView != null) {
                    mView.showRates(response.body());
                }
            }

            @Override
            public void onFailure(Call<Envelope> call, Throwable t) {
                String message = t.getMessage();
                Log.d("failure:" , t.getLocalizedMessage());
                Log.d("failure", message);
                if (mView != null) {
                    mView.showError();
                }
            }
        });
*/
    }

}
