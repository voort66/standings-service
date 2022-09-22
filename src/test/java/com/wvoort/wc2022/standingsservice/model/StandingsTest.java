package com.wvoort.wc2022.standingsservice.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class StandingsTest {

    @Test
    public void testStandingFromJson() throws IOException {
        String standingsJsonString = Files.readString(Paths.get("build/resources/test/standings.json"));

        Standings standings = Standings.fromJsonResponseString(standingsJsonString);
        assertNotNull(standings);
        assertEquals(8, standings.getGroupNames().size());
        System.out.println(standings.getGroupNames());


    }

}