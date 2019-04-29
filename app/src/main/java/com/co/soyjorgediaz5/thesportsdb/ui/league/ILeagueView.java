package com.co.soyjorgediaz5.thesportsdb.ui.league;

import com.co.soyjorgediaz5.thesportsdb.model.team.TeamResponse;

public interface ILeagueView{
    void updateAdapter(TeamResponse teamResponse);
    void showErrorMessageView();
    void hideErrorMessageView();
    void showProgressBar();
    void hideProgressBar();
    void setTeamTitle(String title);
}
