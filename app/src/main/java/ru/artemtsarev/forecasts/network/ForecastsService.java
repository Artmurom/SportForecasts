package ru.artemtsarev.forecasts.network;

import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.artemtsarev.forecasts.model.ArticleDetail;
import ru.artemtsarev.forecasts.model.Result;
import rx.Observable;


public interface ForecastsService {

    @GET("list.php")
    Observable<Result> getEventsList(@Query("category") String category);

    @GET("post.php")
    Observable<ArticleDetail> getArticleDetail(@Query("article") String article);

}
