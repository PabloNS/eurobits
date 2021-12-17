package es.care.sf.scenariosystem.domain.eurobits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AggregationStatusResponse {

    private String executionId;
    private String executionTime;
    private String executionUUID;

}
