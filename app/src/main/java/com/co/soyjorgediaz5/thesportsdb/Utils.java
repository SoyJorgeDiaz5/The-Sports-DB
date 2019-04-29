package com.co.soyjorgediaz5.thesportsdb;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Utils {

    //Base Url
    public static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    //EndPoints
    public static final String SEARCH_ALL_TEAMS_OF_LEAGUE = "search_all_teams.php";
    public static final String NEXT_FIVE_EVENTS_OF_TEAM = "eventsnext.php";

    //Query Params
    public static final String LEAGUE_PARAM_ID = "l";
    public static final String TEAM_PARAM_ID = "id";

    //Default League
    public static final String LEAGUE_LA_LIGA = "Spanish La Liga";
    public static final String LEAGUE_BUNDESLIGA = "German Bundesliga";
    public static final String LEAGUE_PREMIER_LEAGUE = "English Premier League";

    //Extras
    public static final String TEAM_EXTRA = ".LeagueAdapter.TEAM_EXTRA";

    public static void setGlideImg(String imgUrl, Context context, ImageView view){
        Glide.with(context).load(imgUrl).into(view);
    }
}
