package com.co.soyjorgediaz5.thesportsdb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.co.soyjorgediaz5.thesportsdb.R;
import com.co.soyjorgediaz5.thesportsdb.Utils;
import com.co.soyjorgediaz5.thesportsdb.model.team.Team;
import com.co.soyjorgediaz5.thesportsdb.ui.team.TeamActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.co.soyjorgediaz5.thesportsdb.Utils.TEAM_EXTRA;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.TeamsHolder> {

    private List<Team> teamList;
    private Context mContext;

    public LeagueAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TeamsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamsHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.row_teams, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsHolder holder, int position) {
        Team teamItem = teamList.get(position);
        holder.tvTeamName.setText(teamItem.getStrTeam());
        holder.tvTeamStadium.setText(teamItem.getStrStadium());
        Utils.setGlideImg(teamItem.getStrTeamBadge(), mContext, holder.imgTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class TeamsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.img_team)
        ImageView imgTeamBadge;
        @BindView(R.id.tv_team_name)
        TextView tvTeamName;
        @BindView(R.id.tv_team_stadium)
        TextView tvTeamStadium;

        TeamsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mContext.startActivity(new Intent(mContext, TeamActivity.class)
                    .putExtra(TEAM_EXTRA, teamList.get(getLayoutPosition())));
        }
    }
}
