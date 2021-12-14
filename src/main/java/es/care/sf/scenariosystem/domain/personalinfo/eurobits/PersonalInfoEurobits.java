package es.care.sf.scenariosystem.domain.personalinfo.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoEurobits {

    private String username;
    private String document;
    private String birthdate;
    private String[] emails;
    private String[] phoneNumbers;
    private List<AddressEurobits> addresses;
}
