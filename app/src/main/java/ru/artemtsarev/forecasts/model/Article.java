package ru.artemtsarev.forecasts.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Article implements Serializable {

    @SerializedName("header")
    private String mHeader;

    @SerializedName("text")
    private String mText;

    public String getHeader() {
        return mHeader;
    }

    public String getText() {
        return mText;
    }
}
