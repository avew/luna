package github.avew.io.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SptEmetKeyDTO {

    private String npwp;
    private String name;
    private String city;
    private String postalCode;
    private String email;
    private String phone;
    private String address;
    private String aliasName;

    @Builder.Default
    private Boolean pemungut = Boolean.FALSE;

    private LocalDate expiredDate;
    private String serialNumber;
    private List<String> licenseKeys;

}
