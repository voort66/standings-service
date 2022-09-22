package com.wvoort.wc2022.standingsservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Stats {

    private Goals goals;

    private Integer played;

    private Integer loss;

    private Integer win;

    private Integer draw;

}
