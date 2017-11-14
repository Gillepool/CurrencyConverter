package com.example.daniel.currencyconverter.Currency;

import android.util.Log;

import com.example.daniel.currencyconverter.File.FileRepository;
import com.example.daniel.currencyconverter.Network.NetworkRepository;
import com.example.daniel.currencyconverter.Util.NetworkUtil;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import io.reactivex.Single;

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
    public Single<Envelope> getCurrency() {
        Envelope envelope = fileRepository.readFromFile();
        if(envelope == null){
            //networkRepository.getResponse().map(envelope1 -> fileRepository.saveToFile());
            //fileRepository.saveToFile();
        }
        if(!networkUtil.haveConnection()){
            Log.d("ModelCurrency", "No connection");
            return null;
        } else {
            long downloadedTime = envelope.getTimestamp();
            long timeNow = System.currentTimeMillis();
            if(networkUtil.haveWifiConnection()){
                Log.d("ModelCurrency", "wifi connection");

                if(( (timeNow/(1000*60)) - (downloadedTime/(1000*60) ) > 10)){
                    networkRepository.getResponse();
                }
            } else if(networkUtil.haveWifiMobile()){
                Log.d("ModelCurrency", "mobile connection");

                if(( (timeNow/(1000*60)) - (downloadedTime/(1000*60) ) > 60)){
                    networkRepository.getResponse();
                }
            }


        }
        return networkRepository.getResponse();
    }
}

