package com.co.soyjorgediaz5.thesportsdb.ui.team;

import com.co.soyjorgediaz5.thesportsdb.model.event.EventResponse;
import com.co.soyjorgediaz5.thesportsdb.model.team.Team;

public interface ITeamView {
    void updateEvents(EventResponse eventResponse);
    void setTeamInfo(Team team);
}
