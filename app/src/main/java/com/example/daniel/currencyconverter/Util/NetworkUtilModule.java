package com.example.daniel.currencyconverter.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 2017-11-14.
 */
@Module
public class NetworkUtilModule {
    @Provides
    public NetworkInfo getNetworkInfo(Context c){
        ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }
}
