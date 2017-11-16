package com.example.daniel.currencyconverter.Currency;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyAdapter extends ArrayAdapter<CurrencyCube> {



    private final LayoutInflater mInflater;
    private final Context mContext;
    private ArrayList<CurrencyCube> mCurrencies;
    private final int mResource;

    public CurrencyAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        mCurrencies = new ArrayList<>();
    }


    public void updateCurrency(Envelope e){
        mCurrencies = new ArrayList<>(e.getCube().getTimeCube().getCubes());
        notifyDataSetChanged();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView==null){
            convertView =  mInflater.inflate(mResource, parent, false);
        }
        viewHolder = new ViewHolder(convertView);
        CurrencyCube currency = mCurrencies.get(position);
        viewHolder.currency.setText(currency.getCurrency());

        return convertView;
    }


    @Override
    public CurrencyCube getItem(int position) {
        return mCurrencies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mCurrencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1) TextView currency;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
