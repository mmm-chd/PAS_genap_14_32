package com.intent.pas_genap_14_32.fetch_api;

import com.google.gson.annotations.SerializedName;

public class ModelClass {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strBadge")
    private String strBadge;

    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("strSport")
    private String strSpport;

    @SerializedName("strLeague")
    private String strLeague;

    public String getStrEvent() {
        return strEvent;
    }

    public String getStrSpport() {
        return strSpport;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrBadge() {
        return strBadge;
    }
}
