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
        "name",
        "bupot"
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pasal {

    @JsonProperty("name")
    private String name;

    @Builder.Default
    @JsonProperty("bupot")
    private List<Bupot> bupot = new ArrayList<>();

}