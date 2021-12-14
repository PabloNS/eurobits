package es.care.sf.scenariosystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Period {

    private String endDate;
    private String startDate;
}
