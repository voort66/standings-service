package com.wvoort.wc2022.standingsservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Group {

    private List<TeamResult> teamResults;

    public String getGroupName() {
        assert(teamResults != null && !teamResults.isEmpty());
        return teamResults.get(0).getGroup();
    }





}
