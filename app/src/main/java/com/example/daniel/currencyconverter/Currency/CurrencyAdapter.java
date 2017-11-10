package com.example.daniel.currencyconverter.Currency;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.currencyconverter.R;
import com.example.daniel.currencyconverter.XmlModels.Cubes;
import com.example.daniel.currencyconverter.XmlModels.Gesmes;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private String mBase;
    private ArrayList<Cubes> mCurrencies;

    public CurrencyAdapter(String base, Gesmes currencies) {
        mBase = base;
        mCurrencies = new ArrayList<>(currencies.getCube().getCubes());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_rate, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Cubes entry = mCurrencies.get(position);
        final Context context = holder.itemView.getContext();
        holder.currency.setText(entry.getCurrency());
        holder.rate.setText(entry.getRate());
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView currency;
        private TextView rate;

        public ViewHolder(View itemView) {
            super(itemView);
            currency = itemView.findViewById(android.R.id.text1);
            rate = itemView.findViewById(android.R.id.text2);
        }

    }

}
