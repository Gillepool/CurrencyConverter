package com.example.daniel.currencyconverter.Currency;

import android.util.Log;

import com.example.daniel.currencyconverter.File.FileRepository;
import com.example.daniel.currencyconverter.Network.NetworkRepository;
import com.example.daniel.currencyconverter.Util.NetworkUtil;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Observable;

/**
 * Created by Daniel on 2017-11-14.
 */

public class CurrencyModel implements MainContract.Model {
    private NetworkRepository networkRepository;
    private FileRepository fileRepository;
    private NetworkUtil networkUtil;

    public CurrencyModel(NetworkRepository networkRepository,
                         FileRepository fileRepository,
                         NetworkUtil networkUtil){
        this.networkRepository = networkRepository;
        this.fileRepository = fileRepository;
        this.networkUtil = networkUtil;
    }


    @Override
    public Observable<Envelope> getCurrency() {
        Envelope envelope = fileRepository.readFromFile();
        if(envelope == null){
            return networkRepository.getResponse().map(envelope1 -> fileRepository.saveToFile(envelope1));
        }
        if(!networkUtil.haveConnection()){
            Log.d("ModelCurrency", "No connection, reading data from file");
            return Observable.just(fileRepository.readFromFile());
        } else {
            long downloadedTime = envelope.getTimestamp();
            long timeNow = System.currentTimeMillis();
            if(networkUtil.haveWifiConnection()){
                Log.d("ModelCurrency", "wifi connection");

                if(( (timeNow/1000)/60) - ((downloadedTime/1000)/60) > 10){
                    Log.d("ModelCurrency", "Downloading using wifi");

                    return networkRepository.getResponse().map(envelope1 -> fileRepository.saveToFile(envelope1));
                }
            } else if(networkUtil.haveWifiMobile()){
                Log.d("ModelCurrency", "mobile connection");

                if(( (timeNow/1000)/60) - ((downloadedTime/1000)/60) > 60){
                    Log.d("ModelCurrency", "Downloading using mobile data");
                    return networkRepository.getResponse().map(envelope1 -> fileRepository.saveToFile(envelope1));
                }
            }


        }
        Log.d("ModelCurrency", "reading from file");
        return Observable.just(fileRepository.readFromFile());
    }
}
