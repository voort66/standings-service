package com.wvoort.wc2022.standingsservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TeamResult {

    private Integer rank;

    private Team team;

    private String group;

    @EqualsAndHashCode.Exclude
    private Integer points;

    @EqualsAndHashCode.Exclude
    private Integer goalsDiff;

    @EqualsAndHashCode.Exclude
    private Stats all;

    @EqualsAndHashCode.Exclude
    private Stats home;

    @EqualsAndHashCode.Exclude
    private Stats away;

}
