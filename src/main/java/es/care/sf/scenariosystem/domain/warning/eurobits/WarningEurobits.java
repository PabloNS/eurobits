package es.care.sf.scenariosystem.domain.warning.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
public class WarningEurobits extends CommonEntity {

    private String warningCause;
    private String warningDetails;
}
