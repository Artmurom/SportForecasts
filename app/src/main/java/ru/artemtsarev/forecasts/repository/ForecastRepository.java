package ru.artemtsarev.forecasts.repository;

import ru.artemtsarev.forecasts.model.ArticleDetail;
import ru.artemtsarev.forecasts.model.Result;
import rx.Observable;

public interface ForecastRepository {

    Observable<Result> getEventsList(String category);

    Observable<ArticleDetail> getArticleDetail(String article);

}
