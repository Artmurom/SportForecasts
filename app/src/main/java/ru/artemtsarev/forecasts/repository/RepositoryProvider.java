package ru.artemtsarev.forecasts.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public final class RepositoryProvider {

    private static ForecastRepository sForecastRepository;

    private RepositoryProvider() {
    }

    @NonNull
    public static ForecastRepository provideRepository() {
        if (sForecastRepository == null) {
            sForecastRepository = new DefaultForecastRepository();
        }
        return sForecastRepository;
    }

    @SuppressWarnings("unused")
    public static void setRepository(@NonNull ForecastRepository forecastRepository) {
        sForecastRepository = forecastRepository;
    }

    @MainThread
    public static void init() {
        sForecastRepository = new DefaultForecastRepository();
    }
}
