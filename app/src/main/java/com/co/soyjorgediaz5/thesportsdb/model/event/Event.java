package com.co.soyjorgediaz5.thesportsdb.model.event;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event implements Serializable
{
    @SerializedName("idEvent")
    @Expose
    public String idEvent;
    @SerializedName("strEvent")
    @Expose
    public String strEvent;
    @SerializedName("dateEvent")
    @Expose
    public String dateEvent;
    @SerializedName("strTime")
    @Expose
    public String strTime;
    @SerializedName("strThumb")
    @Expose
    public String strThumb;

    /**
     * No args constructor for use in serialization
     *
     */
    public Event() {
    }

    /**
     *
     * @param strThumb
     * @param strTime
     * @param dateEvent
     * @param strEvent
     * @param idEvent
     */
    public Event(String idEvent, String strEvent, String dateEvent, String strTime, String strThumb) {
        super();
        this.idEvent = idEvent;
        this.strEvent = strEvent;
        this.dateEvent = dateEvent;
        this.strTime = strTime;
        this.strThumb = strThumb;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public String getStrTime() {
        return strTime;
    }

    public String getStrThumb() {
        return strThumb;
    }
}