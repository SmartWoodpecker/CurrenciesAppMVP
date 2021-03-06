package rudenko.andrey.currenciesapp.common;

import rudenko.andrey.currenciesapp.presentation.presenter.DateDetailsPresenter;
import rudenko.andrey.currenciesapp.presentation.presenter.DateListPresenter;

public class PresenterManager {

    private static DateListPresenter dateListPresenter;
    private static DateDetailsPresenter dateDetailsPresenter;

    public DateDetailsPresenter getDateDetailsPresenter() {
        if (dateDetailsPresenter == null) {
            dateDetailsPresenter = new DateDetailsPresenter();
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
