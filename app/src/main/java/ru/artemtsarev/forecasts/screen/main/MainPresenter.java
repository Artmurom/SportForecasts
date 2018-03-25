package ru.artemtsarev.forecasts.screen.main;

import ru.artemtsarev.forecasts.repository.RepositoryProvider;


class MainPresenter {

    private final MainView mMainView;

    MainPresenter(MainView mainView) {
        mMainView = mainView;
    }

    void init(String category) {
        RepositoryProvider.provideRepository()
                .getEventsList(category)
                .doOnSubscribe(mMainView::showLoading)
                .doOnTerminate(mMainView::hideLoading)
                .subscribe(mMainView::showEvents, throwable -> mMainView.showError());

    }


}
