package es.care.sf.scenariosystem.domain.common;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class CommonEntity {

    @Id
    private String humanFriendlyName;
}
