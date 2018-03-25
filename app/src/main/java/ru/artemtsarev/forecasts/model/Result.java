package ru.artemtsarev.forecasts.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Result implements Serializable {

    @SerializedName("events")
    private List<Event> mEventList;


    public List<Event> getEventList() {
        return mEventList;
    }

}
