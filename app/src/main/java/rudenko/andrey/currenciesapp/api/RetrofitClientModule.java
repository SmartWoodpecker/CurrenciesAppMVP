package rudenko.andrey.currenciesapp.api;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitClientModule {

    @Provides
    @Singleton
    RetrofitClient provideRetrofitClient() {
        return RetrofitClient.getInstance();
    }
}
