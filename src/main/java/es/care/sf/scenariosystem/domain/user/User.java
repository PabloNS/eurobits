package es.care.sf.scenariosystem.domain.user;

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
    private Long userId;

    private String scenarioEurobitsId;
}
