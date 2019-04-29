package com.co.soyjorgediaz5.thesportsdb.ui.league;

import android.util.Log;

import com.co.soyjorgediaz5.thesportsdb.model.team.TeamResponse;
import com.co.soyjorgediaz5.thesportsdb.network.NetworkClient;
import com.co.soyjorgediaz5.thesportsdb.network.NetworkInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LeaguePresenter {

    private ILeagueView leagueView;
    private String TAG = "d.LeaguePresenter";

    LeaguePresenter(ILeagueView leagueView) {
        this.leagueView = leagueView;
    }

    public void getTeams(String leagueName) {
        leagueView.showProgressBar();
        getObservable(leagueName).subscribeWith(getObserver(leagueName));
    }

    private Observable<TeamResponse> getObservable(String leagueName) {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getTeamsByLeague(leagueName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<TeamResponse> getObserver(String leagueName) {
        return new DisposableObserver<TeamResponse>() {
            @Override
            public void onNext(TeamResponse teamResponse) {
                Log.d(TAG, "OnNext" + teamResponse.getTeams());
                leagueView.hideProgressBar();
                leagueView.updateAdapter(teamResponse);
                leagueView.setTeamTitle(leagueName);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error: "+ e);
                e.printStackTrace();
                leagueView.hideProgressBar();
                leagueView.showErrorMessageView();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                leagueView.hideErrorMessageView();
            }
        };
    }
}
