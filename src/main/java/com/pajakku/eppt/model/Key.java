package com.pajakku.eppt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avew on 2/6/18.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Key {

    private String id;

    private String npwp;

    private String name;

    private String sn;

    private String expiredAt;

    @Builder.Default
    private List<Pasal> pasal = new ArrayList<>();


}