package ru.artemtsarev.forecasts;

import android.app.Application;

import ru.artemtsarev.forecasts.network.ApiFactory;
import ru.artemtsarev.forecasts.repository.RepositoryProvider;


public class ForecastsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ApiFactory.recreate();
        RepositoryProvider.init();
    }
}
