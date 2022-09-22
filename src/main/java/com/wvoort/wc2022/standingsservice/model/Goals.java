package com.wvoort.wc2022.standingsservice.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Goals {

    @SerializedName(value = "for")
    private Integer forGoals;

    @SerializedName(value = "against" )
    private Integer againstGoals;
}
