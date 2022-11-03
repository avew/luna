package github.avew.io.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCustomFeaturesKey {

    private String companyName;
    private String serialNumber;
    private List<String> customFeaturesKey;

}