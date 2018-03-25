package ru.artemtsarev.forecasts.screen.main;


import ru.artemtsarev.forecasts.model.Result;

public interface MainView {

    void showEvents(Result result);

    void showError();

    void showLoading();

    void hideLoading();

}