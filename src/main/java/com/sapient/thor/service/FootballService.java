package com.sapient.thor.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sapient.thor.pojo.LeagueDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class FootballService {

    public ArrayList<LeagueDetails> getStandings(Integer leagueId, String apiKey) {

        final String uri = "https://apiv3.apifootball.com/?action=get_standings&league_id="+leagueId+"&APIkey="+apiKey;
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<HashMap> leagues = (ArrayList) restTemplate.getForObject(uri, Object.class);
        List<LeagueDetails> items = new ArrayList<>();

        for (int i = 0; i < leagues.size(); i++) {

            LeagueDetails leagueDetails = new LeagueDetails();
            leagueDetails.setLeagueId(Integer.valueOf((String) leagues.get(i).get("league_id")));
            leagueDetails.setLeagueName((String) leagues.get(i).get("league_name"));
            leagueDetails.setCountryName((String) leagues.get(i).get("country_name"));
            leagueDetails.setTeamId(Integer.valueOf((String) leagues.get(i).get("team_id")));
            leagueDetails.setTeamName((String) leagues.get(i).get("team_name"));
            leagueDetails.setLeaguePayed((String) leagues.get(i).get("overall_league_payed"));
            leagueDetails.setLeaguePosition((String) leagues.get(i).get("overall_league_position"));
            leagueDetails.setOveralPromotion((String) leagues.get(i).get("overall_promotion"));

            items.add(leagueDetails);
        }

        return (ArrayList<LeagueDetails>) items;
    }
}
