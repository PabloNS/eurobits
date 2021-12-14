package es.care.sf.scenariosystem.domain.personalinfo.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEurobits {

    private String addressDescription;
    private String streetAddress;
    private String city;
    private String stateProvinceRegion;
    private String zipCode;
    private String country;
}
