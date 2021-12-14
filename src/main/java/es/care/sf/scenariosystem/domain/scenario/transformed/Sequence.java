package es.care.sf.scenariosystem.domain.scenario.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {

    private String id;
    private int position;
    private int size;
    private String executor;
}
