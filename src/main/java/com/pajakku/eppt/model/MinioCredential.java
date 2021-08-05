package com.pajakku.eppt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MinioCredential {

    private String endpoint;
    private String access;
    private String secret;

}
