package es.care.sf.scenariosystem.domain.pensionplan.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionPlanEurobits {

    private String planNumber;
    private String planName;
    private String webAlias;
    private String startDate;
    private MoneyEurobits balance;
    private String valueDate;
    private MoneyEurobits totalContribution;
    private MoneyEurobits yearToDateContribution;
    private MoneyEurobits totalPerformance;
    private MoneyEurobits yearToDatePerformance;
    private PlanPerformanceEurobits planPerformance;
    private String lastTwelveMonthsPerformance;
    //TODO String in API doc
    private MoneyEurobits yield;
    private Double quantity;
    private Double unitPrice;
    private List<PensionPlanTransactionEurobits> transactions;
}
