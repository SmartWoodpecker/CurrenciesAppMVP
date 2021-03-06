package rudenko.andrey.currenciesapp.presentation.view;

import rudenko.andrey.currenciesapp.entity.AllValuteEntity;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface DateDetailsView {
    void showCurrenciesCourse(AllValuteEntity valute);

    void showConnectionError();

    void showProgressBar();

    void hideProgressBar();
}
