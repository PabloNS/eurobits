package es.care.sf.scenariosystem.domain.scenario.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String requestStatus;
    private String execId;
    private Long startRequestDate;
    private String providerResponseCode;
    private BankExtract bankExtract;
    private String dynamicParam;
    private String productWarnings;
    private String providerErrorCode;
    private String providerErrorMessage;
    private String periodUpdateCounter;
}
