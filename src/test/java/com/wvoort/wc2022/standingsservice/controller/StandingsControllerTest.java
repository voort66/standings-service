package com.wvoort.wc2022.standingsservice.controller;

import com.wvoort.wc2022.standingsservice.model.Group;
import com.wvoort.wc2022.standingsservice.model.Standings;
import com.wvoort.wc2022.standingsservice.model.Team;
import com.wvoort.wc2022.standingsservice.model.TeamResult;
import com.wvoort.wc2022.standingsservice.service.StandingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@WebMvcTest(StandingsWebController.class)
class StandingsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StandingsService standingsService;

    @BeforeEach
    void setUp() {

        Group group = new Group();
        TeamResult tr1 = new TeamResult();
        tr1.setGroup("Group A");
        Team t1 = new Team();
        t1.setName("Belgium");
        tr1.setTeam(t1);

        TeamResult tr2 = new TeamResult();
        tr2.setGroup("Group A");
        Team t2 = new Team();
        t2.setName("Qatar");
        tr1.setTeam(t1);

        group.setTeamResults(Arrays.asList(tr1, tr2));

        List<Group> groups = Collections.singletonList(group);
        Standings standings = new Standings(groups);





        when(standingsService.getStandings()).thenReturn(standings);
    }

    @Test
    void testGetFixtures() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/fixtures")
//                       .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andReturn();
//
//        String resultSS = result.getResponse().getContentAsString();
//        assertNotNull(resultSS);
//        assertEquals("[{'type': 'season'}]", resultSS);
    }

}