package com.co.soyjorgediaz5.thesportsdb.model.team;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team implements Serializable {

    @SerializedName("idTeam")
    @Expose
    private String idTeam;
    @SerializedName("strTeam")
    @Expose
    private String strTeam;
    @SerializedName("intFormedYear")
    @Expose
    private String intFormedYear;
    @SerializedName("strStadium")
    @Expose
    private String strStadium;
    @SerializedName("strStadiumThumb")
    @Expose
    private String strStadiumThumb;
    @SerializedName("strDescriptionEN")
    @Expose
    private String strDescriptionEN;
    @SerializedName("strTeamBadge")
    @Expose
    private String strTeamBadge;
    @SerializedName("strTeamJersey")
    @Expose
    private String strTeamJersey;
    @SerializedName("strWebsite")
    @Expose
    private String strWebsite;
    @SerializedName("strFacebook")
    @Expose
    private String strFacebook;
    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;
    @SerializedName("strTwitter")
    @Expose
    private String strTwitter;
    @SerializedName("strInstagram")
    @Expose
    private String strInstagram;

    /**
     * No args constructor for use in serialization
     *
     */
    public Team() {
    }

    /**
     *
     * @param strDescriptionEN
     * @param strTwitter
     * @param strWebsite
     * @param intFormedYear
     * @param idTeam
     * @param strYoutube
     * @param strFacebook
     * @param strStadium
     * @param strTeamBadge
     * @param strStadiumThumb
     * @param strTeamJersey
     * @param strTeam
     * @param strInstagram
     */
    public Team(String idTeam, String strTeam, String intFormedYear, String strStadium, String strStadiumThumb, String strDescriptionEN, String strTeamBadge, String strTeamJersey, String strWebsite, String strFacebook, String strYoutube, String strTwitter, String strInstagram) {
        super();
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.intFormedYear = intFormedYear;
        this.strStadium = strStadium;
        this.strStadiumThumb = strStadiumThumb;
        this.strDescriptionEN = strDescriptionEN;
        this.strTeamBadge = strTeamBadge;
        this.strTeamJersey = strTeamJersey;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strYoutube = strYoutube;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }
}