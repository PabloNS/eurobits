package es.care.sf.scenariosystem.domain.accountholder.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolderEurobits {

    private String name;
    private String document;
    private String relation;
    private String type;
    private String category;
}
