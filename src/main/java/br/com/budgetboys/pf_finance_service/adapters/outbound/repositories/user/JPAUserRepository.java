package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.user;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JPAUserRepository extends JpaRepository<JPAUserEntity, UUID> {
}
