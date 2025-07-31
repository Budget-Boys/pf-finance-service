package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JPAExpenseRepository extends JpaRepository<JPAExpenseEntity, UUID> {
    List<JPAExpenseEntity> findAllByUserId(UUID userId);
}
