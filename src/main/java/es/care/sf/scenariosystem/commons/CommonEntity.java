package es.care.sf.scenariosystem.commons;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class CommonEntity {

    @Id
    private String humanFriendlyName;
}
