package az.edu.orient.repository;

import az.edu.orient.entity.AccountEntity;
import az.edu.orient.type.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findAllByUserIdAndCurrency(int userId, Currency currency);
}
