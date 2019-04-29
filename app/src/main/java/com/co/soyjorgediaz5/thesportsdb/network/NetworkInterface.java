package com.co.soyjorgediaz5.thesportsdb.network;

import com.co.soyjorgediaz5.thesportsdb.model.event.EventResponse;
import com.co.soyjorgediaz5.thesportsdb.model.team.TeamResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.co.soyjorgediaz5.thesportsdb.Utils.LEAGUE_PARAM_ID;
import static com.co.soyjorgediaz5.thesportsdb.Utils.NEXT_FIVE_EVENTS_OF_TEAM;
import static com.co.soyjorgediaz5.thesportsdb.Utils.SEARCH_ALL_TEAMS_OF_LEAGUE;
import static com.co.soyjorgediaz5.thesportsdb.Utils.TEAM_PARAM_ID;

public interface NetworkInterface {
    @GET(SEARCH_ALL_TEAMS_OF_LEAGUE)
    Observable<TeamResponse> getTeamsByLeague(@Query(LEAGUE_PARAM_ID) String league_param_id);

    @GET(NEXT_FIVE_EVENTS_OF_TEAM)
    Observable<EventResponse> getNextFiveEventsByTeam(@Query(TEAM_PARAM_ID) String team_param_id);
}
