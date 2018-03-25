package ru.artemtsarev.forecasts.screen.person;

import ru.artemtsarev.forecasts.repository.RepositoryProvider;


class ArticlePresenter {

    private final ArticleView mArticleView;

    ArticlePresenter(ArticleView articleView) {
        mArticleView = articleView;
    }

    void init(String article) {
        RepositoryProvider.provideRepository()
                .getArticleDetail(article)
                .subscribe(mArticleView::initUI, throwable -> mArticleView.showError());
    }

}
