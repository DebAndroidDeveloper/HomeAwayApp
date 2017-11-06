package com.homeaway.homeawayapp.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.homeaway.homeawayapp.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventServiceResponse {
    public List<Event> getEventData() {
        return eventData;
    }

    public void setEventData(List<Event> eventData) {
        this.eventData = eventData;
    }

    @SerializedName("events")
    @Expose
    private List<Event> eventData = null;
}