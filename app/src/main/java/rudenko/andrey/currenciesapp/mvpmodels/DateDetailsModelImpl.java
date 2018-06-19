package rudenko.andrey.currenciesapp.mvpmodels;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import rudenko.andrey.currenciesapp.CurrenciesApp;
import rudenko.andrey.currenciesapp.api.CurrencyApi;
import rudenko.andrey.currenciesapp.api.RetrofitClient;
import rudenko.andrey.currenciesapp.entity.AllValuteEntity;
import rudenko.andrey.currenciesapp.entity.ValuteEntity;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateDetailsModelImpl implements DateDetailsModel{

    @Inject
    public RetrofitClient currencyApi;

    @Override
    public Single<AllValuteEntity> getAllCurrency(String year, String month, String day) {
//        RetrofitClient.getInstance();
        CurrenciesApp.getComponent().inject(this);
        Single<AllValuteEntity> response = RetrofitClient.getCurrencyApiService().getCurrency(year, month, day);
        response = response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return response;
    }
}
