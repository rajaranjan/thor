package com.sapient.thor.api;

import com.sapient.thor.pojo.LeagueDetails;
import com.sapient.thor.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FootballApi {


    @Value("${app.key}") // Injecting the value of app.key from application.properties
    private String apiKey;

    @Autowired
    private FootballService footballService;

    private LeagueDetails leagueDetails;

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "hello world";
    }


    @GetMapping( path = "/get-standing" )
    @ResponseBody()
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<LeagueDetails> getStanding(@RequestParam("league_id") Integer leagueId) {
//        return "League Id: " + leagueId + ", Api Key: " + apiKey;
        ArrayList<LeagueDetails> lDetails = footballService.getStandings(leagueId, apiKey);
        return lDetails;
    }

}
