package com.sapient.thor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.thor.api.FootballApi;
import com.sapient.thor.pojo.LeagueDetails;
import com.sapient.thor.service.FootballService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.bytebuddy.matcher.ElementMatchers.isArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(FootballApi.class)
public class FootballApiTests {
    private static final String END_POINT_PATH = "/get-standing";

//    @Value("${app.key}") // Injecting the value of app.key from application.properties
//    private String apiKey;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private FootballService service;

    @Test
    public void testGetStandingReturn200Ok() throws Exception {
        Integer leagueId = 152;
        String apiKey = "19fc6fc6fc7c4aa7c901950ed16974b463998b551fc8c59b49574fad731ae253";

        LeagueDetails leagueDetails = new LeagueDetails(152, "Premier League", "England", 84, "Liverpool", "Promotion - Champions League (League phase: )", "1", "7");
        ArrayList<LeagueDetails> list = new ArrayList<>();
        list.add(leagueDetails);

        when(service.getStandings(leagueId,apiKey)).thenReturn(list);

        // Build Mock Request
        RequestBuilder request = get(END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("league_id", String.valueOf(leagueId));

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
