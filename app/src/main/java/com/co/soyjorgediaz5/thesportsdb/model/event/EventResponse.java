package com.co.soyjorgediaz5.thesportsdb.model.event;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EventResponse {

    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public EventResponse() {
    }

    /**
     *
     * @param events
     */
    public EventResponse(List<Event> events) {
        super();
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
