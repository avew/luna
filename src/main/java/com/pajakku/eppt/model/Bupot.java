package com.pajakku.eppt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by avew on 2/6/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nama",
        "count"
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bupot {

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("count")
    private Integer count;
}