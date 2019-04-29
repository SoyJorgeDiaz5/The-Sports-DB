package com.co.soyjorgediaz5.thesportsdb.ui.team;

import android.util.Log;

import com.co.soyjorgediaz5.thesportsdb.model.event.EventResponse;
import com.co.soyjorgediaz5.thesportsdb.model.team.TeamResponse;
import com.co.soyjorgediaz5.thesportsdb.network.NetworkClient;
import com.co.soyjorgediaz5.thesportsdb.network.NetworkInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class TeamPresenter {

    private ITeamView teamView;
    private String TAG = "d.TeamPresenter";

    TeamPresenter(ITeamView teamView) {
        this.teamView = teamView;
    }

    void getEvents(String teamId) {
        getObservable(teamId).subscribeWith(getObserver());
    }

    private Observable<EventResponse> getObservable(String teamId) {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getNextFiveEventsByTeam(teamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<EventResponse> getObserver() {
        return new DisposableObserver<EventResponse>() {
            @Override
            public void onNext(EventResponse eventResponse) {
                Log.d(TAG, "OnNext" + eventResponse.getEvents());
                teamView.updateEvents(eventResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error: "+ e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
