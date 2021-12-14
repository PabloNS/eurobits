package es.care.sf.scenariosystem.repository;

import es.care.sf.scenariosystem.domain.account.transformed.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
