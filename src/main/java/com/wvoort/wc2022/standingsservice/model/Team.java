package com.wvoort.wc2022.standingsservice.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Team {
    private Long id;

    private String name;

    @EqualsAndHashCode.Exclude
    private String logo;
}
