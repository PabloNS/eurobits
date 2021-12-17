package es.care.sf.scenariosystem.domain.user;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.UserEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(UserEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scenarioEurobitsId;
}
