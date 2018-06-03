package rudenko.andrey.currenciesapp.presentation.presenter;


import java.util.Date;

import rudenko.andrey.currenciesapp.mvpmodels.DateModelImpl;
import rudenko.andrey.currenciesapp.mvpmodels.DateModel;
import rudenko.andrey.currenciesapp.presentation.view.DateListActivity;
import rudenko.andrey.currenciesapp.presentation.view.DateListView;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class DateListPresenter {

    private DateModel dateModel = new DateModelImpl();
    private DateListActivity view;


    public void attachView(DateListActivity dateDetailsActivity) {
        view = dateDetailsActivity;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        view.createScrollListener();
        getDate(0);
    }

    public void getDate(int itemCount) {
        dateModel.setItemcount(itemCount);
        dateModel.addDateToList();
        view.addProposalsToList(dateModel.getModeldateList());
    }

    public void dateListItemClicked(Date date) {
        view.navigateToDateDetailsAtcivity(date);
    }
}
