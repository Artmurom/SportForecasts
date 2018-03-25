package ru.artemtsarev.forecasts.network;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.artemtsarev.forecasts.BuildConfig;


public final class ApiFactory {

    private static volatile ForecastsService sService;

    private ApiFactory() {
    }

    @NonNull
    public static ForecastsService getForecastService() {
        ForecastsService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = buildRetrofit().create(ForecastsService.class);
                }
            }
        }
        return service;
    }

    public static void recreate() {
        sService = buildRetrofit().create(ForecastsService.class);
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
