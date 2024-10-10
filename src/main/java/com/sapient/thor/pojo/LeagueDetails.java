package com.sapient.thor.pojo;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LeagueDetails {

    private Integer leagueId;
    private String leagueName;
    private String countryName;
    private Integer teamId;
    private String teamName;
    private String overalPromotion;
    private String leaguePosition;
    private String leaguePayed;

    public LeagueDetails() {

    }
    public LeagueDetails(Integer leagueId, String leagueName, String countryName, Integer teamId, String teamName, String overalPromotion, String leaguePosition, String leaguePayed) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.countryName = countryName;
        this.teamId = teamId;
        this.teamName = teamName;
        this.overalPromotion = overalPromotion;
        this.leaguePosition = leaguePosition;
        this.leaguePayed = leaguePayed;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOveralPromotion() {
        return overalPromotion;
    }

    public void setOveralPromotion(String overalPromotion) {
        this.overalPromotion = overalPromotion;
    }

    public String getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(String leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public String getLeaguePayed() {
        return leaguePayed;
    }

    public void setLeaguePayed(String leaguePayed) {
        this.leaguePayed = leaguePayed;
    }

    @Override
    public String toString() {
        return "LeagueDetails{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", overalPromotion='" + overalPromotion + '\'' +
                ", leaguePosition='" + leaguePosition + '\'' +
                ", leaguePayed='" + leaguePayed + '\'' +
                '}';
    }
}
