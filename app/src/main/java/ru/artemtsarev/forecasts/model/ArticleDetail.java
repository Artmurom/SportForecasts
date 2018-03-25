package ru.artemtsarev.forecasts.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ArticleDetail implements Serializable {

    @SerializedName("team1")
    private String mTeam1;

    @SerializedName("team2")
    private String mTeam2;

    @SerializedName("time")
    private String mTime;

    @SerializedName("tournament")
    private String mTournament;

    @SerializedName("place")
    private String mPlace;

    @SerializedName("article")
    private List<Article> mArticleList;

    @SerializedName("prediction")
    private String mPrediction;

    public String getTeam1() {
        return mTeam1;
    }

    public String getTeam2() {
        return mTeam2;
    }

    public String getTime() {
        return mTime;
    }

    public String getTournament() {
        return mTournament;
    }

    public String getPlace() {
        return mPlace;
    }

    public List<Article> getArticleList() {
        return mArticleList;
    }

    public String getPrediction() {
        return mPrediction;
    }
}
