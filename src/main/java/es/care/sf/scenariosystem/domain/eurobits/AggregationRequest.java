package es.care.sf.scenariosystem.domain.eurobits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(exclude = "credentials")
public class AggregationRequest {

    private List<String> products;
    private List<Credential> credentials;
    private String fromDate;
    private String toDate;
    private Boolean extendedTrxData;
    private Boolean encryptedCredentials;
    private String certificateId;
    private String robotName;
    private String userId;

}
