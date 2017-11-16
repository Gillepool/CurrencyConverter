package com.example.daniel.currencyconverter.Util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * Created by Daniel on 2017-11-12.
 */

public class NetworkUtil {
    private NetworkInfo networkInfo;

    @Inject
    public NetworkUtil(NetworkInfo networkInfo){ this.networkInfo = networkInfo; }

    public boolean haveConnection(){
        NetworkInfo networkInfo = this.networkInfo;
        if(networkInfo!=null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    public  boolean haveWifiConnection(){
        NetworkInfo networkInfo = this.networkInfo;
        if(networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
            return true;
        else
            return false;
    }

    public  boolean haveWifiMobile(){
        NetworkInfo networkInfo = this.networkInfo;
        if(networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
            return true;
        else
            return false;
    }


}
