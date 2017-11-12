package com.example.daniel.currencyconverter.Scheduler;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Daniel on 2017-11-11.
 */

public class Schedule {

    @Inject
    public Schedule(){}

    public Scheduler getScheduler(){
        return Schedulers.io();
    }

    public Scheduler getMainThread(){
        return AndroidSchedulers.mainThread();
    }

}
