package ru.artemtsarev.forecasts.screen.person;


import ru.artemtsarev.forecasts.model.ArticleDetail;

public interface ArticleView {

    void initUI(ArticleDetail articleDetail);

    void showError();

}