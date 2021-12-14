package es.care.sf.scenariosystem.domain.pensionplan.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanPerformanceEurobits {

    private String total;
    private String yearToDate;
    private String lastTwelveMonths;
}
