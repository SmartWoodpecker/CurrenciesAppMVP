package rudenko.andrey.currenciesapp;

import android.app.Application;

import rudenko.andrey.currenciesapp.common.PresenterManager;

public class CurrenciesApp extends Application {

    PresenterManager presenterManager =new PresenterManager();

    public PresenterManager getPresenterManager() {
        return presenterManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenterManager = new PresenterManager();
    }
}
