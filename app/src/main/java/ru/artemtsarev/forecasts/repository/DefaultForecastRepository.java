package ru.artemtsarev.forecasts.repository;

import android.support.annotation.NonNull;

import ru.artemtsarev.forecasts.model.ArticleDetail;
import ru.artemtsarev.forecasts.model.Result;
import ru.artemtsarev.forecasts.network.ApiFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DefaultForecastRepository implements ForecastRepository {

    @NonNull
    @Override
    public Observable<Result> getEventsList(String category) {
        return ApiFactory.getForecastService()
                .getEventsList(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<ArticleDetail> getArticleDetail(String article) {
        return ApiFactory.getForecastService()
                .getArticleDetail(article)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
