package es.care.sf.scenariosystem.domain.scenario.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenario {

    private String careRequestId;
    private String userId;
    private String systemBankId;
    private String bankId;
    private String fingerprint;
    private Sequence sequence;
    private Response response;
    private String requestCompany;
    private String requestCompanyHolder;
    private String[] requestedProducts;
}
