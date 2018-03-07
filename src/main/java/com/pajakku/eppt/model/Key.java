package com.pajakku.eppt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avew on 2/6/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "npwp",
        "name",
        "sn",
        "expiredAt",
        "access"
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Key {

    @JsonProperty("npwp")
    private String npwp;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sn")
    private String sn;

    @JsonProperty("expiredAt")
    private String expiredAt;

    @Builder.Default
    @JsonProperty("pasal")
    private List<Pasal> pasal = new ArrayList<>();


}