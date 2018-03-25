package ru.artemtsarev.forecasts.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Event implements Serializable {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("coefficient")
    private String mCoefficient;

    @SerializedName("time")
    private String mTime;

    @SerializedName("place")
    private String mPlace;

    @SerializedName("preview")
    private String mPreview;

    @SerializedName("article")
    private String mArticle;

    public String getTitle() {
        return mTitle;
    }

    public String getCoefficient() {
        return mCoefficient;
    }

    public String getTime() {
        return mTime;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getPreview() {
        return mPreview;
    }

    public String getArticle() {
        return mArticle;
    }
}
