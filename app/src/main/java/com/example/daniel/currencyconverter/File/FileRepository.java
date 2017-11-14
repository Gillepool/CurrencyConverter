package com.example.daniel.currencyconverter.File;

import android.content.Context;

import com.example.daniel.currencyconverter.Currency.CurrencyRepository;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.inject.Inject;

/**
 * Created by Daniel on 2017-11-12.
 */

public class FileRepository implements CurrencyRepository.File {

    private static final String filename = "currency.txt";


    private Context context;
    @Inject
    public FileRepository(Context context){
        this.context = context;
    }

    @Override
    public Envelope readFromFile() {
        Envelope envelope = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            envelope = (Envelope) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return envelope;
    }

    @Override
    public void saveToFile(Envelope envelope) {
        envelope.setTimestamp(System.currentTimeMillis());
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(envelope);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
