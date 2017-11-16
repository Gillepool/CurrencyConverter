package com.example.daniel.currencyconverter.Currency;

import com.example.daniel.currencyconverter.CurrencyApplicationModule;
import com.example.daniel.currencyconverter.File.FileRepository;
import com.example.daniel.currencyconverter.Network.NetworkModule;
import com.example.daniel.currencyconverter.Network.NetworkRepository;
import com.example.daniel.currencyconverter.Util.NetworkUtil;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 2017-11-12.
 */

@Module(includes = {NetworkModule.class, CurrencyApplicationModule.class})
public class CurrencyModule {

    /*
    @Provides
    public MainContract.Presenter provideMainContractPresenter(Schedule schedule){
        return new MainPresenter(schedule);
    }
    */

    @Provides
    public CurrencyRepository.Network providesCurrencyRepository(CurrencyApi currencyApi){
        return new NetworkRepository(currencyApi);
    }

    @Provides
    public MainContract.Model providesCurrencyModel(NetworkRepository networkRepository,
                                                    FileRepository fileRepository,
                                                    NetworkUtil networkUtil){
        return new CurrencyModel(networkRepository, fileRepository, networkUtil);
    }


}
