package com.example.daniel.currencyconverter.File;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 2017-11-12.
 */

@Module
public class FileModule {
    private Context context;

    public FileModule(Context context) {
        this.context = context;
    }

    @Provides
    Context providesContext() {
        return context;
    }
}
