package es.care.sf.scenariosystem.repository;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEurobitsRepository extends JpaRepository<AccountEurobits, String> {

}
