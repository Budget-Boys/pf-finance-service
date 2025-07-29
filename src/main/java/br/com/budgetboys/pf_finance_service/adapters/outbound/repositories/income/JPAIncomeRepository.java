package br.com.budgetboys.pf_finance_service.adapters.outbound.repositories.income;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAExpenseEntity;
import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.JPAIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JPAIncomeRepository extends JpaRepository<JPAIncomeEntity, UUID> {
    List<JPAIncomeEntity> findAllByUserId(UUID userId);
}
