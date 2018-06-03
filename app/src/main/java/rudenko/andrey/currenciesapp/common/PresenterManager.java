package rudenko.andrey.currenciesapp.common;

import rudenko.andrey.currenciesapp.presentation.presenter.DateDetailsPresenter;
import rudenko.andrey.currenciesapp.presentation.presenter.DateListPresenter;

public class PresenterManager {

    private static DateListPresenter dateListPresenter;
    private static DateDetailsPresenter dateDetailsPresenter;

    public DateDetailsPresenter getDateDetailsPresenter(String year, String month, String day) {
        if (dateDetailsPresenter == null) {
            dateDetailsPresenter = new DateDetailsPresenter(year, month, day);
        }
        return dateDetailsPresenter;
    }

    public DateListPresenter getDateListPresenter() {
        if (dateListPresenter == null) {
            dateListPresenter = new DateListPresenter();
        }
        return dateListPresenter;
    }


}
