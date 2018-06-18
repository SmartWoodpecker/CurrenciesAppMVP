package rudenko.andrey.currenciesapp;

import android.app.Application;

import dagger.android.support.DaggerAppCompatActivity;
import dagger.internal.DaggerCollections;
import rudenko.andrey.currenciesapp.api.RetrofitClientModule;
import rudenko.andrey.currenciesapp.common.AppComponent;
import rudenko.andrey.currenciesapp.common.DaggerAppComponent;
import rudenko.andrey.currenciesapp.common.PresenterManager;

public class CurrenciesApp extends Application {

    PresenterManager presenterManager;
    private static AppComponent component;

    public static AppComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

     protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .retrofitClientModule(new RetrofitClientModule())
                .build();
     }

    public PresenterManager getPresenterManager() {
        if (presenterManager == null) {
            presenterManager = new PresenterManager();
        }
        return presenterManager;
    }


}
