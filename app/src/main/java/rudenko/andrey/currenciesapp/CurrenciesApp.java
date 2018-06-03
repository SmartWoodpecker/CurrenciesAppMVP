package rudenko.andrey.currenciesapp;

import android.app.Application;

import rudenko.andrey.currenciesapp.common.PresenterManager;

public class CurrenciesApp extends Application {

    PresenterManager presenterManager;

    public PresenterManager getPresenterManager() {
        if (presenterManager == null) {
            presenterManager = new PresenterManager();
        }
        return presenterManager;
    }
}
