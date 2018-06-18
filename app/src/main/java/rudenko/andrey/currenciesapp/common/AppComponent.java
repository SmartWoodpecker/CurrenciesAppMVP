package rudenko.andrey.currenciesapp.common;

import javax.inject.Singleton;

import dagger.Component;
import rudenko.andrey.currenciesapp.api.RetrofitClientModule;
import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModelImpl;
import rudenko.andrey.currenciesapp.mvpmodels.DateModelImpl;

@Component (modules = {RetrofitClientModule.class})
@Singleton
public interface AppComponent {

    void inject (DateDetailsModelImpl dateDetailsModelImpl);
    void inject (DateModelImpl dateModelImpl);
}
