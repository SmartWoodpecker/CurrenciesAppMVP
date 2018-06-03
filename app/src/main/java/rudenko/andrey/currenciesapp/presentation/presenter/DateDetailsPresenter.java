package rudenko.andrey.currenciesapp.presentation.presenter;

import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModelImpl;
import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModel;
import rudenko.andrey.currenciesapp.presentation.view.DateDetailsActivity;
import rudenko.andrey.currenciesapp.presentation.view.DateDetailsView;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateDetailsPresenter {

    private DateDetailsModel dateModel = new DateDetailsModelImpl();
    private DateDetailsActivity view;
    private String month;
    private String year;
    private String day;

    public DateDetailsPresenter(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void attachView(DateDetailsActivity dateDetailsActivity) {
        view = dateDetailsActivity;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        getCurrency();
    }

    private void getCurrency() {
        view.showProgressBar();
        dateModel.getAllCurrency(year, month, day)
                .doAfterTerminate(() -> view.hideProgressBar())
                .subscribe(currencies -> view.showCurrenciesCourse(currencies),
                        error -> view.showConnectionError()
                );
    }

}
