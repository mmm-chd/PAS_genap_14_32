package com.intent.pas_genap_14_32.fetch_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getPremierLeagueTeams();

    @GET("/api/v1/json/3/eventsseason.php?id=4328&s=2014-2015")
    Call<TeamResponse> getEventsSeason();
}
