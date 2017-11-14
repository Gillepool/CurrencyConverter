package com.example.daniel.currencyconverter.Currency

import android.util.Log
import com.example.daniel.currencyconverter.File.FileRepository
import com.example.daniel.currencyconverter.Network.NetworkRepository
import com.example.daniel.currencyconverter.Util.NetworkUtil
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope
import io.reactivex.Single

/**
 * Created by Daniel on 2017-11-14.
 */

class CurrencyModel(private val networkRepository: NetworkRepository,
                    private val fileRepository: FileRepository,
                    private val networkUtil: NetworkUtil) : MainContract.Model {


    override fun getCurrency(): Single<Envelope>? {
        val envelope = fileRepository.readFromFile()
        if (envelope == null) {
            if (networkUtil.haveConnection()) {
                val envelopeSingle = networkRepository.response
                        .map { envelope1 -> fileRepository.saveToFile(envelope1) }
                Log.d("ModelCurrency", " " + envelopeSingle.toString())

            }
        }
        if (!networkUtil.haveConnection()) {
            Log.d("ModelCurrency", "No connection")
            return null
        } else {
            val downloadedTime = envelope!!.timestamp
            val timeNow = System.currentTimeMillis()
            if (networkUtil.haveWifiConnection()) {
                Log.d("ModelCurrency", "wifi connection")

                if (timeNow / (1000 * 60) - downloadedTime / (1000 * 60) > 10) {
                    networkRepository.response
                }
            } else if (networkUtil.haveWifiMobile()) {
                Log.d("ModelCurrency", "mobile connection")

                if (timeNow / (1000 * 60) - downloadedTime / (1000 * 60) > 60) {
                    networkRepository.response
                }
            }


        }
        return networkRepository.response
    }
}
