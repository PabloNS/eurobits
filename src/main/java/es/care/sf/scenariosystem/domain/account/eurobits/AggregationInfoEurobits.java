package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.domain.warning.eurobits.WarningEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregationInfoEurobits {

    private String code;
    private String message;
    private List<?> companies;
    private List<WarningEurobits> warnings;
    private String robotCode;
}
