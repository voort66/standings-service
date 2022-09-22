package com.wvoort.wc2022.standingsservice.service;

import com.wvoort.wc2022.standingsservice.ApplicationConfig;
import com.wvoort.wc2022.standingsservice.model.Standings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
class StandingsServiceTest {

    @Autowired
    private StandingsService standingsService;

    @MockBean
    private RestTemplate restTemplate;

    private ResponseEntity<String> responseEntity;


    private Standings standings;

    @BeforeEach
    void setUp() throws IOException {
        String jsonString = Files.readString(Paths.get("build/resources/test/standings.json"));
        standings = Standings.fromJsonResponseString(jsonString);
        responseEntity =  mock(ResponseEntity.class);
        when(responseEntity.getBody()).thenReturn(jsonString);
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(responseEntity);

    }


    @Test
    void testStandings() {
        assertEquals(standings, standingsService.getStandings());
    }

}