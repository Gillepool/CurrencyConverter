package com.example.daniel.currencyconverter.Currency;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.currencyconverter.R;
import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private ArrayList<CurrencyCube> mCurrencies;
    private String date;

    public CurrencyAdapter(Envelope currencies) {
        mCurrencies = new ArrayList<>(currencies.getCube().getTimeCube().getCubes());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_rate, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CurrencyCube entry = mCurrencies.get(position);
        final Context context = holder.itemView.getContext();
        Log.d("response", "Setting currency to " + entry.getCurrency());
        Log.d("response", "Setting rate to " + entry.getRate());
        holder.currency.setText(entry.getCurrency());
        holder.rate.setText(entry.getRate());
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1) TextView currency;
        @BindView(android.R.id.text2) TextView rate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
