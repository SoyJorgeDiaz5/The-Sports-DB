package com.co.soyjorgediaz5.thesportsdb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.co.soyjorgediaz5.thesportsdb.R;
import com.co.soyjorgediaz5.thesportsdb.ui.league.LeagueActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initHandler();
    }

    private void initHandler(){
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LeagueActivity.class));
            SplashActivity.this.finish();
        }, 1000); // 1 second
    }

}
