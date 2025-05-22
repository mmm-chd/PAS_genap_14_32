package com.intent.pas_genap_14_32.fetch_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<ModelClass> teams;

    public List<ModelClass> getTeams() {
        return teams;
    }

    @SerializedName("events")
    private  List<ModelClass> events;

    public List<ModelClass> getEvents() {return events;}
}
