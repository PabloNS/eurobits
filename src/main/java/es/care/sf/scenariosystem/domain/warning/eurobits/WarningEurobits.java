package es.care.sf.scenariosystem.domain.warning.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarningEurobits {

    private String warningCause;
    private String warningDetails;
}
