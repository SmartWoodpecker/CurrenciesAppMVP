package rudenko.andrey.currenciesapp.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import rudenko.andrey.currenciesapp.CurrenciesApp;
import rudenko.andrey.currenciesapp.R;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.presentation.presenter.DateDetailsPresenter;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateDetailsActivity extends AppCompatActivity implements DateDetailsView {


    DateDetailsPresenter presenter;
    ProgressBar progressBar;
    CurrenciesApp app;
    Boolean isConfigChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            isConfigChange = savedInstanceState.getBoolean("changeConfig");
        }
        setContentView(R.layout.activity_date_details);
        app = (CurrenciesApp) getApplicationContext();
        initializeToolbar();
        initializeProgressBar();
        initPresenter();
    }

    public void initPresenter() {

        Intent myIntent = getIntent();
        String month = myIntent.getStringExtra("month");
        String year = myIntent.getStringExtra("year");
        String day = myIntent.getStringExtra("day");
        presenter = app.getPresenterManager().getDateDetailsPresenter();
        presenter.attachView(this);
        presenter.initDate(year, month, day);
        if (!isConfigChange) {
            presenter.firstInitialPresenter();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("changeConfig", true);
    }

    public void initializeToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        getSupportActionBar().setTitle(R.string.course);
    }

    public void initializeProgressBar() {
        progressBar = findViewById(R.id.pb_date_details);
    }

    @Override
    public void showCurrenciesCourse(AllValuteEntity valute) {
        TextView tv_usd_ammount = findViewById(R.id.tv_usd_ammount);
        TextView tv_eur_ammount = findViewById(R.id.tv_eur_ammount);
        tv_usd_ammount.setText(valute.getValute().getUsd().getValue().toString());
        tv_eur_ammount.setText(valute.getValute().getEur().getValue().toString());
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, "Ошибка получения данных с сервера", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
