package com.co.soyjorgediaz5.thesportsdb.ui.team;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.co.soyjorgediaz5.thesportsdb.R;
import com.co.soyjorgediaz5.thesportsdb.Utils;
import com.co.soyjorgediaz5.thesportsdb.adapter.EventsAdapter;
import com.co.soyjorgediaz5.thesportsdb.model.event.EventResponse;
import com.co.soyjorgediaz5.thesportsdb.model.team.Team;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.co.soyjorgediaz5.thesportsdb.Utils.TEAM_EXTRA;

public class TeamActivity extends AppCompatActivity implements ITeamView {

    @BindView(R.id.img_team_stadium)
    ImageView imgTeamStadium;
    @BindView(R.id.img_team_badge)
    ImageView imgTeamBadge;
    @BindView(R.id.rv_events)
    RecyclerView rvEvents;
    @BindView(R.id.tv_team_description)
    TextView tvTeamDescription;
    @BindView(R.id.img_team_jersey)
    ImageView imgTeamJersey;
    @BindView(R.id.tv_foundation_year)
    TextView tvFoundationYear;
    @BindView(R.id.img_website_team)
    ImageView imgWebsite;
    @BindView(R.id.img_facebook_team)
    ImageView imgFacebook;
    @BindView(R.id.img_twitter_team)
    ImageView imgTwitter;
    @BindView(R.id.img_instagram_team)
    ImageView imgInstagram;
    @BindView(R.id.img_youtube_team)
    ImageView imgYoutube;
    private TeamPresenter teamPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        teamPresenter = new TeamPresenter(this);
        setRecyclerView();
        Team teamItem = (Team) getIntent().getSerializableExtra(TEAM_EXTRA);
        setTeamInfo(teamItem);
        getEventsList(teamItem.getIdTeam());
        setTitle(teamItem.getStrTeam());
    }

    private void getEventsList(String teamId) {
        teamPresenter.getEvents(teamId);
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rvEvents.setLayoutManager(layoutManager);
    }

    @Override
    public void updateEvents(EventResponse eventResponse) {
        if (eventResponse != null) {
            EventsAdapter eventsAdapter = new EventsAdapter(eventResponse.getEvents());
            rvEvents.setAdapter(eventsAdapter);
        }
    }

    @Override
    public void setTeamInfo(Team team) {
        Utils.setGlideImg(team.getStrStadiumThumb(), this, imgTeamStadium);
        Utils.setGlideImg(team.getStrTeamBadge(), this, imgTeamBadge);
        Utils.setGlideImg(team.getStrTeamJersey(), this, imgTeamJersey);
        tvTeamDescription.setText(team.getStrDescriptionEN());
        tvFoundationYear.setText(team.getIntFormedYear());
        showSocialNetworks(team);
    }

    private void showSocialNetworks(Team team) {
        checkEmptySocialNetwork(imgWebsite, team.getStrWebsite());
        checkEmptySocialNetwork(imgFacebook, team.getStrFacebook());
        checkEmptySocialNetwork(imgTwitter, team.getStrTwitter());
        checkEmptySocialNetwork(imgInstagram, team.getStrInstagram());
        checkEmptySocialNetwork(imgYoutube, team.getStrYoutube());
    }

    private void checkEmptySocialNetwork(ImageView imageView, String url) {
        if (!url.isEmpty()){
            enableSocialOption(imageView, url);
        }
    }

    private void enableSocialOption(ImageView imageView, String url) {
        imageView.setVisibility(View.VISIBLE);
        imageView.setOnClickListener(view -> openSocialOption(url));
    }

    private void openSocialOption(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url)));
    }
}
