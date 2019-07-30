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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bupot {

    private String nama;
    private Integer count;
}