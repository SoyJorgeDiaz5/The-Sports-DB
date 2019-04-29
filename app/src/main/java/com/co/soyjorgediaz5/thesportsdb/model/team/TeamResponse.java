package com.co.soyjorgediaz5.thesportsdb.model.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamResponse {

    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TeamResponse() {
    }

    /**
     *
     * @param teams
     */
    public TeamResponse(List<Team> teams) {
        super();
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
