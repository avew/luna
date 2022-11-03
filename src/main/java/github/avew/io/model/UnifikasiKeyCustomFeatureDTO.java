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
public class UnifikasiKeyCustomFeatureDTO {

    private int companyId;
    private List<String> customFeatures;
    private String expiredDate;

}
