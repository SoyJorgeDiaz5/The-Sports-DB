package com.co.soyjorgediaz5.thesportsdb.ui.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.co.soyjorgediaz5.thesportsdb.R;
import com.co.soyjorgediaz5.thesportsdb.adapter.LeagueAdapter;
import com.co.soyjorgediaz5.thesportsdb.model.team.TeamResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.co.soyjorgediaz5.thesportsdb.Utils.LEAGUE_BUNDESLIGA;
import static com.co.soyjorgediaz5.thesportsdb.Utils.LEAGUE_LA_LIGA;
import static com.co.soyjorgediaz5.thesportsdb.Utils.LEAGUE_PREMIER_LEAGUE;

public class LeagueActivity extends AppCompatActivity implements ILeagueView {

    @BindView(R.id.rv_teams)
    RecyclerView rvTeams;
    @BindView(R.id.progressbar_teams)
    ProgressBar progressBarTeams;
    @BindView(R.id.img_error)
    ImageView imgErrorMessage;
    @BindView(R.id.tv_error)
    TextView tvErrorMessage;

    private LeaguePresenter leaguePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        ButterKnife.bind(this);

        leaguePresenter = new LeaguePresenter(this);
        setRecyclerView();
        setTeamTitle(LEAGUE_LA_LIGA);
        getTeamList(LEAGUE_LA_LIGA);
    }

    private void getTeamList(String leagueName){
        leaguePresenter.getTeams(leagueName);
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                layoutManager.getOrientation());
        rvTeams.setLayoutManager(layoutManager);
        rvTeams.addItemDecoration(itemDecoration);
    }

    @Override
    public void updateAdapter(TeamResponse teamResponse){
        if (teamResponse != null){
            LeagueAdapter leagueAdapter = new LeagueAdapter(teamResponse.getTeams(), LeagueActivity.this);
            rvTeams.setAdapter(leagueAdapter);
        }
    }

    @Override
    public void showErrorMessageView() {
        rvTeams.setVisibility(View.GONE);
        imgErrorMessage.setVisibility(View.VISIBLE);
        tvErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMessageView() {
        imgErrorMessage.setVisibility(View.GONE);
        tvErrorMessage.setVisibility(View.GONE);
        rvTeams.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
        progressBarTeams.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarTeams.setVisibility(View.GONE);
    }

    @Override
    public void setTeamTitle(String title) {
        setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_leagues, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_la_liga:
                getTeamList(LEAGUE_LA_LIGA);
                return true;
            case R.id.menu_bundesliga:
                getTeamList(LEAGUE_BUNDESLIGA);
                return true;
            case R.id.menu_premier_league:
                getTeamList(LEAGUE_PREMIER_LEAGUE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
