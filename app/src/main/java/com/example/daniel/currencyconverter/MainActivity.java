package com.example.daniel.currencyconverter;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daniel.currencyconverter.Currency.CurrencyAdapter;
import com.example.daniel.currencyconverter.Currency.MainContract;
import com.example.daniel.currencyconverter.Currency.MainPresenter;
import com.example.daniel.currencyconverter.XmlResponseModels.CurrencyCube;
import com.example.daniel.currencyconverter.XmlResponseModels.Envelope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainContract.View {

    @Inject
    MainPresenter mPresenter;

    private CurrencyAdapter currencyAdapter;
    private CurrencyCube fromCurrency;
    private CurrencyCube toCurrency;

    private static final String STATE_FROM_VALUE = "stateFromValue";
    private static final String STATE_FROM_SPINNER = "stateFromSpinner";
    private static final String STATE_TO_SPINNER = "stateToSpinner";

    private int fromSelected = 0;
    private int toSelected = 1;


    @BindView(R.id.from_currency_text_edit) TextInputEditText fromCurrencyTextEdit;
    @BindView(R.id.from_currency_text_layout) TextInputLayout fromCurrencyTextLayout;
    @BindView(R.id.spinner_from_currency) Spinner spinnerFromCurrency;

    @BindView(R.id.to_currency_text_edit) TextInputEditText toCurrencyTextEdit;
    @BindView(R.id.to_currency_text_layout) TextInputLayout toCurrencyTextLayout;
    @BindView(R.id.spinner_to_currency) Spinner spinnerToCurrency;

    @BindView(R.id.switch_button) Button switchButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        ((CurrencyApplication) getApplication()).getCurrencyApplicationComponent().inject(this);





        currencyAdapter = new CurrencyAdapter(this, R.layout.item_rate);
        spinnerFromCurrency.setAdapter(currencyAdapter);
        spinnerToCurrency.setAdapter(currencyAdapter);

        mPresenter.setView(this);
        mPresenter.onBaseSelected();

        if (savedInstanceState != null) {
            mPresenter.onBaseSelected();
            fromCurrencyTextEdit.setText( savedInstanceState.getString("stateFromValue")) ;
            toSelected = savedInstanceState.getInt("stateToSpinner");
            fromSelected = savedInstanceState.getInt("stateFromSpinner");
        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putString(STATE_FROM_VALUE, fromCurrencyTextEdit.getText().toString());

        savedInstanceState.putInt(STATE_FROM_SPINNER, spinnerFromCurrency.getSelectedItemPosition());
        savedInstanceState.putInt(STATE_TO_SPINNER, spinnerToCurrency.getSelectedItemPosition());

        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.setView(null);
        spinnerToCurrency.setAdapter(null);
        spinnerFromCurrency.setAdapter(null);
    }

    @Override
    public void showError() {
        showText(getResources().getString(R.string.error));
        spinnerToCurrency.setAdapter(null);
        spinnerFromCurrency.setAdapter(null);

    }

    @Override
    public void showResult(String value){
        toCurrencyTextEdit.setText(value);
    }

    @Override
    public void showRates(Envelope rates) {
        currencyAdapter.updateCurrency(rates);
        spinnerToCurrency.setSelection(toSelected);
        spinnerFromCurrency.setSelection(fromSelected);
        spinnerToCurrency.setOnItemSelectedListener(new onSelectedItemListenerToCurrency());
        spinnerFromCurrency.setOnItemSelectedListener(new onSelectedItemListenerFromCurrency());
        fromCurrencyTextEdit.addTextChangedListener(new onTextChangedListener());
        switchButton.setOnClickListener(new onSwitchButtonClick());
    }

    private class onTextChangedListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mPresenter.onValueChanged(  Double.parseDouble(fromCurrency.getRate()), Double.parseDouble(toCurrency.getRate()), s.toString());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private class onSelectedItemListenerFromCurrency implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            fromCurrency  =  (CurrencyCube) parentView.getItemAtPosition(position);
            fromCurrencyTextLayout.setHint(fromCurrency.getCurrency());

    //        mPresenter.onValueChanged(  Double.parseDouble(fromCurrency.getRate()), Double.parseDouble(toCurrency.getRate()), fromCurrencyTextEdit.getText().toString());

        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }
    }

    private class onSelectedItemListenerToCurrency implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            toCurrency  = (CurrencyCube) parentView.getItemAtPosition(position);
            toCurrencyTextLayout.setHint(toCurrency.getCurrency());
            mPresenter.onValueChanged(  Double.parseDouble(fromCurrency.getRate()), Double.parseDouble(toCurrency.getRate()), fromCurrencyTextEdit.getText().toString());

        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }
    }

    private class onSwitchButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int temp = spinnerFromCurrency.getSelectedItemPosition();
            spinnerFromCurrency.setSelection(spinnerToCurrency.getSelectedItemPosition());
            spinnerToCurrency.setSelection(temp);
        }
    }

    private void showText(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }



}
