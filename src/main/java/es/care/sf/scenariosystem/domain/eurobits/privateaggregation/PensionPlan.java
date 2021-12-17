package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(exclude = "planNumber")
public class PensionPlan {

    private Money balance;
    private String planName;
    private String planNumber;
    private PensionPlanPerformance planPerformance;
    private String quantity;
    private String startDate;
    private Money totalContribution;
    private Double unitPrice;
    private String valueDate;
    private String webAlias;
    private Money yearToDateContribution;
    private Money yield;
}
