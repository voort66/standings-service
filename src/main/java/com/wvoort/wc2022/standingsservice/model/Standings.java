package com.wvoort.wc2022.standingsservice.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@EqualsAndHashCode
public class Standings {

    private final List<Group> groups;

    public Standings(List<Group> groups) {
        this.groups = groups;
    }



    public List<String> getGroupNames() {
        return groups.stream().map(g -> g.getGroupName()).sorted().collect(Collectors.toList());
    }

    public Group getGroupByName(String groupName) {
        return groups.stream().filter(g -> g.getGroupName().equalsIgnoreCase(groupName)).findFirst().get();
    }

    public List<Group> getGroups() {
        return Collections.unmodifiableList(groups);
    }


    public static Standings fromJsonResponseString(String standingsJson) {
        JsonElement jsonElement = JsonParser.parseString(standingsJson);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement responseElement = jsonObject.get("response");
        JsonElement leagueElement = responseElement.getAsJsonArray().get(0).getAsJsonObject().get("league");
        final JsonElement standingsElement = leagueElement.getAsJsonObject().get("standings");
        final JsonArray standingsJsonArray = standingsElement.getAsJsonArray();

        final List<Group> groups =  StreamSupport.stream(standingsJsonArray.spliterator(), false).map(e -> {
            Group group = new Group();
            TeamResult[] teamResultsArray = new Gson().fromJson(e.toString(), TeamResult[].class);
            group.setTeamResults(Arrays.asList(teamResultsArray));
            return group;
        }).collect(Collectors.toList());


        Standings standings = new Standings(groups);

        return standings;

    }
}
